package com.example.phanmanhtung_baitapeventvalidation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phanmanhtung_baitapeventvalidation.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayRegistrationInfo()

        binding.btnBack.setOnClickListener {
            finish()
        }

        Snackbar.make(
            binding.root,
            "Đăng ký thành công",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun displayRegistrationInfo() {
        binding.tvFullName.text = getRegistrationValue(RegistrationExtras.FULL_NAME)
        binding.tvEmail.text = getRegistrationValue(RegistrationExtras.EMAIL)
        binding.tvPhone.text = getRegistrationValue(RegistrationExtras.PHONE)
        binding.tvStudentId.text = getRegistrationValue(RegistrationExtras.STUDENT_ID)
        binding.tvClassName.text = getRegistrationValue(RegistrationExtras.CLASS_NAME)
    }

    private fun getRegistrationValue(key: String): String {
        return intent.getStringExtra(key) ?: "Không có dữ liệu"
    }
}