package com.wisecloud.app.util

import com.wisecloud.app.data.model.response.DeviceSummary

/**
 * 设备筛选工具类
 * 按在线状态筛选设备列表
 */
object DeviceFilterUtil {

    enum class OnlineFilter { ALL, ONLINE, OFFLINE }

    /**
     * 按在线状态筛选设备列表
     * @param devices 原始设备列表
     * @param filter 筛选条件
     * @return 筛选后的设备列表
     */
    fun filterByOnlineStatus(
        devices: List<DeviceSummary>,
        filter: OnlineFilter
    ): List<DeviceSummary> = when (filter) {
        OnlineFilter.ALL -> devices
        OnlineFilter.ONLINE -> devices.filter { it.onlineStatus == 1 }
        OnlineFilter.OFFLINE -> devices.filter { it.onlineStatus == 2 }
    }
}
