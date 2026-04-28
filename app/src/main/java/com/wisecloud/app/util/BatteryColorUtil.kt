package com.wisecloud.app.util

import com.wisecloud.app.R

/**
 * 电量颜色映射工具类
 * 根据电量百分比返回对应颜色资源 ID
 */
object BatteryColorUtil {

    /**
     * 根据电量百分比返回对应颜色
     * @param batteryLevel 电量百分比 (0-100)
     * @return 颜色资源 ID
     *   - 0~20: 红色 (R.color.battery_low)
     *   - 21~50: 黄色 (R.color.battery_medium)
     *   - 51~100: 绿色 (R.color.battery_high)
     */
    fun getColor(batteryLevel: Int): Int = when {
        batteryLevel <= 20 -> R.color.battery_low
        batteryLevel <= 50 -> R.color.battery_medium
        else -> R.color.battery_high
    }
}
