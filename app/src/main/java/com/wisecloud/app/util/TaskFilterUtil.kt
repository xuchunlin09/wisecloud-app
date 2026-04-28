package com.wisecloud.app.util

import com.wisecloud.app.data.model.response.TaskSummary

/**
 * 任务筛选工具类
 * 按任务类型筛选任务列表
 */
object TaskFilterUtil {

    /**
     * 按任务类型筛选任务列表
     * @param tasks 原始任务列表
     * @param type 筛选类型，null 表示全部
     * @return 筛选后的任务列表
     */
    fun filterByType(
        tasks: List<TaskSummary>,
        type: String?
    ): List<TaskSummary> = if (type == null) tasks
        else tasks.filter { it.taskType == type }
}
