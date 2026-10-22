package com.example.phanmanhtung_baitapeventvalidation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.phanmanhtung_baitapeventvalidation.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var hasSubmitted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Phan Manh Tung - 2415053122347"
        setupRealtimeValidation()

        binding.btnRegister.setOnClickListener {
            hasSubmitted = true

            if (validateForm()) {
                openDetailScreen()
            } else {
                Snackbar.make(
                    binding.root,
                    "Vui lòng kiểm tra lại thông tin đã nhập",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setupRealtimeValidation() {
        binding.edtFullName.doAfterTextChanged {
            if (hasSubmitted) {
                binding.tilFullName.error =
                    RegistrationValidator.validateName(it.toString())
            }
        }

        binding.edtEmail.doAfterTextChanged {
            if (hasSubmitted) {
                binding.tilEmail.error =
                    RegistrationValidator.validateEmail(it.toString())
            }
        }

        binding.edtPhone.doAfterTextChanged {
            if (hasSubmitted) {
                binding.tilPhone.error =
                    RegistrationValidator.validatePhone(it.toString())
            }
        }

        binding.edtStudentId.doAfterTextChanged {
            if (hasSubmitted) {
                binding.tilStudentId.error =
                    RegistrationValidator.validateStudentId(it.toString())
            }
        }

        binding.edtClassName.doAfterTextChanged {
            if (hasSubmitted) {
                binding.tilClassName.error =
                    RegistrationValidator.validateClassName(it.toString())
            }
        }
    }

    private fun validateForm(): Boolean {
        val nameError =
            RegistrationValidator.validateName(binding.edtFullName.text.toString())
        val emailError =
            RegistrationValidator.validateEmail(binding.edtEmail.text.toString())
        val phoneError =
            RegistrationValidator.validatePhone(binding.edtPhone.text.toString())
        val studentIdError =
            RegistrationValidator.validateStudentId(binding.edtStudentId.text.toString())
        val classError =
            RegistrationValidator.validateClassName(binding.edtClassName.text.toString())

        binding.tilFullName.error = nameError
        binding.tilEmail.error = emailError
        binding.tilPhone.error = phoneError
        binding.tilStudentId.error = studentIdError
        binding.tilClassName.error = classError

        return nameError == null &&
                emailError == null &&
                phoneError == null &&
                studentIdError == null &&
                classError == null
    }

    private fun openDetailScreen() {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(
                RegistrationExtras.FULL_NAME,
                binding.edtFullName.text.toString().trim()
            )
            putExtra(
                RegistrationExtras.EMAIL,
                binding.edtEmail.text.toString().trim()
            )
            putExtra(
                RegistrationExtras.PHONE,
                binding.edtPhone.text.toString().trim()
            )
            putExtra(
                RegistrationExtras.STUDENT_ID,
                binding.edtStudentId.text.toString().trim()
            )
            putExtra(
                RegistrationExtras.CLASS_NAME,
                binding.edtClassName.text.toString().trim()
            )
        }

        startActivity(intent)
    }
}