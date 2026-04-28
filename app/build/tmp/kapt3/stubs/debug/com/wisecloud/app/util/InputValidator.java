package com.wisecloud.app.util;

/**
 * 输入校验工具类
 * 提供邮箱、密码、MFA 验证码、邮箱验证码的格式校验
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/wisecloud/app/util/InputValidator;", "", "()V", "EMAIL_REGEX", "Lkotlin/text/Regex;", "isValidEmail", "", "email", "", "isValidMfaCode", "code", "isValidPassword", "password", "isValidVerificationCode", "app_debug"})
public final class InputValidator {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex EMAIL_REGEX = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.util.InputValidator INSTANCE = null;
    
    private InputValidator() {
        super();
    }
    
    /**
     * 校验邮箱格式是否合法
     */
    public final boolean isValidEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return false;
    }
    
    /**
     * 校验密码强度（至少 8 位）
     */
    public final boolean isValidPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return false;
    }
    
    /**
     * 校验 MFA 验证码（6 位纯数字）
     */
    public final boolean isValidMfaCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
        return false;
    }
    
    /**
     * 校验邮箱验证码（非空）
     */
    public final boolean isValidVerificationCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
        return false;
    }
}