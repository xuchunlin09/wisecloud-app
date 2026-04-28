package com.wisecloud.app.util;

import com.wisecloud.app.data.model.response.DeviceSummary;

/**
 * 设备筛选工具类
 * 按在线状态筛选设备列表
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lcom/wisecloud/app/util/DeviceFilterUtil;", "", "()V", "filterByOnlineStatus", "", "Lcom/wisecloud/app/data/model/response/DeviceSummary;", "devices", "filter", "Lcom/wisecloud/app/util/DeviceFilterUtil$OnlineFilter;", "OnlineFilter", "app_debug"})
public final class DeviceFilterUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.util.DeviceFilterUtil INSTANCE = null;
    
    private DeviceFilterUtil() {
        super();
    }
    
    /**
     * 按在线状态筛选设备列表
     * @param devices 原始设备列表
     * @param filter 筛选条件
     * @return 筛选后的设备列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wisecloud.app.data.model.response.DeviceSummary> filterByOnlineStatus(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wisecloud.app.data.model.response.DeviceSummary> devices, @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.util.DeviceFilterUtil.OnlineFilter filter) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wisecloud/app/util/DeviceFilterUtil$OnlineFilter;", "", "(Ljava/lang/String;I)V", "ALL", "ONLINE", "OFFLINE", "app_debug"})
    public static enum OnlineFilter {
        /*public static final*/ ALL /* = new ALL() */,
        /*public static final*/ ONLINE /* = new ONLINE() */,
        /*public static final*/ OFFLINE /* = new OFFLINE() */;
        
        OnlineFilter() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.wisecloud.app.util.DeviceFilterUtil.OnlineFilter> getEntries() {
            return null;
        }
    }
}