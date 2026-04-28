package com.wisecloud.app.util;

import com.wisecloud.app.data.model.response.TaskDeviceStatus;

/**
 * 任务进度计算工具类
 * 提供进度计算、状态分组、终态检测功能
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2 = {"Lcom/wisecloud/app/util/TaskProgressUtil;", "", "()V", "calculateProgress", "Lcom/wisecloud/app/util/TaskProgressUtil$TaskProgress;", "statuses", "", "Lcom/wisecloud/app/data/model/response/TaskDeviceStatus;", "groupByStatus", "Lcom/wisecloud/app/util/TaskStatusGroups;", "isAllTerminal", "", "TaskProgress", "app_debug"})
public final class TaskProgressUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.util.TaskProgressUtil INSTANCE = null;
    
    private TaskProgressUtil() {
        super();
    }
    
    /**
     * 根据设备状态列表计算任务进度
     * @param statuses 设备执行状态列表
     * @return 进度信息
     */
    @org.jetbrains.annotations.NotNull()
    public final com.wisecloud.app.util.TaskProgressUtil.TaskProgress calculateProgress(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wisecloud.app.data.model.response.TaskDeviceStatus> statuses) {
        return null;
    }
    
    /**
     * 按 instructionStatus 分组设备状态
     * @param statuses 设备执行状态列表
     * @return 四组分组结果 (completed, failed, executing, preparing)
     */
    @org.jetbrains.annotations.NotNull()
    public final com.wisecloud.app.util.TaskStatusGroups groupByStatus(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wisecloud.app.data.model.response.TaskDeviceStatus> statuses) {
        return null;
    }
    
    /**
     * 判断任务是否全部到达终态
     * @param statuses 设备执行状态列表
     * @return 当且仅当所有设备 instructionStatus 为 3 或 4 时返回 true
     */
    public final boolean isAllTerminal(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wisecloud.app.data.model.response.TaskDeviceStatus> statuses) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u000bH\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/wisecloud/app/util/TaskProgressUtil$TaskProgress;", "", "completedCount", "", "failedCount", "executingCount", "preparingCount", "totalCount", "progressPercent", "", "progressText", "", "(IIIIIFLjava/lang/String;)V", "getCompletedCount", "()I", "getExecutingCount", "getFailedCount", "getPreparingCount", "getProgressPercent", "()F", "getProgressText", "()Ljava/lang/String;", "getTotalCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class TaskProgress {
        private final int completedCount = 0;
        private final int failedCount = 0;
        private final int executingCount = 0;
        private final int preparingCount = 0;
        private final int totalCount = 0;
        private final float progressPercent = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String progressText = null;
        
        public TaskProgress(int completedCount, int failedCount, int executingCount, int preparingCount, int totalCount, float progressPercent, @org.jetbrains.annotations.NotNull()
        java.lang.String progressText) {
            super();
        }
        
        public final int getCompletedCount() {
            return 0;
        }
        
        public final int getFailedCount() {
            return 0;
        }
        
        public final int getExecutingCount() {
            return 0;
        }
        
        public final int getPreparingCount() {
            return 0;
        }
        
        public final int getTotalCount() {
            return 0;
        }
        
        public final float getProgressPercent() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getProgressText() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final float component6() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.util.TaskProgressUtil.TaskProgress copy(int completedCount, int failedCount, int executingCount, int preparingCount, int totalCount, float progressPercent, @org.jetbrains.annotations.NotNull()
        java.lang.String progressText) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}