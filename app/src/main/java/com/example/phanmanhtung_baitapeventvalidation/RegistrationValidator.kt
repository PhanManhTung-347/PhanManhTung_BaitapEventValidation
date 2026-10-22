package com.example.phanmanhtung_baitapeventvalidation

object RegistrationValidator {

    fun validateName(value: String): String? {
        val name = value.trim()
        val nameRegex = Regex("""^[\p{L}]+(?:[ '\-][\p{L}]+)*$""")

        if (name.isEmpty()) return "Vui lòng nhập họ tên"
        if (name.length < 2) return "Họ tên phải có ít nhất 2 ký tự"
        if (!nameRegex.matches(name)) {
            return "Họ tên chỉ được chứa chữ cái, khoảng trắng hoặc dấu gạch nối"
        }

        return null
    }

    fun validateEmail(value: String): String? {
        val email = value.trim()
        val emailRegex =
            Regex("""^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$""")

        if (email.isEmpty()) return "Vui lòng nhập email"
        if (!emailRegex.matches(email)) return "Email không đúng định dạng"

        return null
    }

    fun validatePhone(value: String): String? {
        val phone = value.trim()
        val phoneRegex = Regex("""^0[0-9]{9}$""")

        if (phone.isEmpty()) return "Vui lòng nhập số điện thoại"
        if (!phoneRegex.matches(phone)) {
            return "Số điện thoại phải gồm 10 chữ số và bắt đầu bằng 0"
        }

        return null
    }

    fun validateStudentId(value: String): String? {
        val studentId = value.trim()
        val studentIdRegex = Regex("""^[0-9]{6,15}$""")

        if (studentId.isEmpty()) return "Vui lòng nhập mã sinh viên"
        if (!studentIdRegex.matches(studentId)) {
            return "Mã sinh viên phải gồm từ 6 đến 15 chữ số"
        }

        return null
    }

    fun validateClassName(value: String): String? {
        val className = value.trim()
        val classRegex = Regex("""^[A-Za-z0-9][A-Za-z0-9 ._-]{1,19}$""")

        if (className.isEmpty()) return "Vui lòng nhập lớp"
        if (!classRegex.matches(className)) {
            return "Tên lớp gồm 2–20 ký tự chữ, số hoặc dấu . _ -"
        }

        return null
    }
}