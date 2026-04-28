package com.wisecloud.app.util

import android.content.Context
import android.view.View
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * 常用 Kotlin 扩展函数
 */

// ===== View 可见性切换 =====

/** 设置 View 为可见 */
fun View.visible() {
    visibility = View.VISIBLE
}

/** 设置 View 为不可见（保留占位） */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/** 设置 View 为隐藏（不保留占位） */
fun View.gone() {
    visibility = View.GONE
}

/** 根据条件切换 View 可见性 */
fun View.visibleIf(condition: Boolean) {
    visibility = if (condition) View.VISIBLE else View.GONE
}

// ===== Toast 快捷方法 =====

/** 显示短 Toast */
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/** 显示长 Toast */
fun Context.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

// ===== 日期格式化 =====

/** 将 ISO 日期字符串格式化为 "yyyy-MM-dd HH:mm" */
fun String.formatDateTime(): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val date = inputFormat.parse(this)
        date?.let { outputFormat.format(it) } ?: this
    } catch (e: Exception) {
        this
    }
}

/** 将 Date 对象格式化为 "yyyy-MM-dd HH:mm" */
fun Date.formatDateTime(): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    return format.format(this)
}

/** 将 Date 对象格式化为 "yyyy-MM-dd" */
fun Date.formatDate(): String {
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return format.format(this)
}
