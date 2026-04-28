package com.wisecloud.app.util;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\t2\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\t2\u0006\u0010\n\u001a\u00020\u0001\u001a\n\u0010\f\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\r\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"formatDate", "", "Ljava/util/Date;", "formatDateTime", "gone", "", "Landroid/view/View;", "invisible", "showLongToast", "Landroid/content/Context;", "message", "showToast", "visible", "visibleIf", "condition", "", "app_debug"})
public final class ExtensionsKt {
    
    /**
     * 设置 View 为可见
     */
    public static final void visible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visible) {
    }
    
    /**
     * 设置 View 为不可见（保留占位）
     */
    public static final void invisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$invisible) {
    }
    
    /**
     * 设置 View 为隐藏（不保留占位）
     */
    public static final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$gone) {
    }
    
    /**
     * 根据条件切换 View 可见性
     */
    public static final void visibleIf(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visibleIf, boolean condition) {
    }
    
    /**
     * 显示短 Toast
     */
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * 显示长 Toast
     */
    public static final void showLongToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showLongToast, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * 将 ISO 日期字符串格式化为 "yyyy-MM-dd HH:mm"
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatDateTime(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$formatDateTime) {
        return null;
    }
    
    /**
     * 将 Date 对象格式化为 "yyyy-MM-dd HH:mm"
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatDateTime(@org.jetbrains.annotations.NotNull()
    java.util.Date $this$formatDateTime) {
        return null;
    }
    
    /**
     * 将 Date 对象格式化为 "yyyy-MM-dd"
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatDate(@org.jetbrains.annotations.NotNull()
    java.util.Date $this$formatDate) {
        return null;
    }
}