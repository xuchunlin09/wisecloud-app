package com.wisecloud.app.util

/**
 * 输入校验工具类
 * 提供邮箱、密码、MFA 验证码、邮箱验证码的格式校验
 */
object InputValidator {

    private val EMAIL_REGEX = Regex(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    )

    /** 校验邮箱格式是否合法 */
    fun isValidEmail(email: String): Boolean = EMAIL_REGEX.matches(email.trim())

    /** 校验密码强度（至少 8 位） */
    fun isValidPassword(password: String): Boolean = password.length >= 8

    /** 校验 MFA 验证码（6 位纯数字） */
    fun isValidMfaCode(code: String): Boolean = code.length == 6 && code.all { it.isDigit() }

    /** 校验邮箱验证码（非空） */
    fun isValidVerificationCode(code: String): Boolean = code.isNotBlank()
}
