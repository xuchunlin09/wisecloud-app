package com.wisecloud.app.util;

import com.wisecloud.app.data.model.response.TaskSummary;

/**
 * 任务筛选工具类
 * 按任务类型筛选任务列表
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/wisecloud/app/util/TaskFilterUtil;", "", "()V", "filterByType", "", "Lcom/wisecloud/app/data/model/response/TaskSummary;", "tasks", "type", "", "app_debug"})
public final class TaskFilterUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.util.TaskFilterUtil INSTANCE = null;
    
    private TaskFilterUtil() {
        super();
    }
    
    /**
     * 按任务类型筛选任务列表
     * @param tasks 原始任务列表
     * @param type 筛选类型，null 表示全部
     * @return 筛选后的任务列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wisecloud.app.data.model.response.TaskSummary> filterByType(@org.jetbrains.annotations.NotNull()
    java.util.List<com.wisecloud.app.data.model.response.TaskSummary> tasks, @org.jetbrains.annotations.Nullable()
    java.lang.String type) {
        return null;
    }
}