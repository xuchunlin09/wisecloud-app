package com.wisecloud.app.util

import com.wisecloud.app.data.model.response.TaskDeviceStatus

/**
 * 任务进度计算工具类
 * 提供进度计算、状态分组、终态检测功能
 */
object TaskProgressUtil {

    data class TaskProgress(
        val completedCount: Int,
        val failedCount: Int,
        val executingCount: Int,
        val preparingCount: Int,
        val totalCount: Int,
        val progressPercent: Float,   // 0.0 ~ 1.0
        val progressText: String      // e.g. "7/12 Completed"
    )

    /**
     * 根据设备状态列表计算任务进度
     * @param statuses 设备执行状态列表
     * @return 进度信息
     */
    fun calculateProgress(statuses: List<TaskDeviceStatus>): TaskProgress {
        val totalCount = statuses.size
        val completedCount = statuses.count { it.instructionStatus == 3 }
        val failedCount = statuses.count { it.instructionStatus == 4 }
        val executingCount = statuses.count { it.instructionStatus == 2 }
        val preparingCount = statuses.count { it.instructionStatus == 1 }

        val progressPercent = if (totalCount > 0) {
            (completedCount + failedCount).toFloat() / totalCount
        } else {
            0f
        }

        val progressText = "$completedCount/$totalCount Completed"

        return TaskProgress(
            completedCount = completedCount,
            failedCount = failedCount,
            executingCount = executingCount,
            preparingCount = preparingCount,
            totalCount = totalCount,
            progressPercent = progressPercent,
            progressText = progressText
        )
    }

    /**
     * 按 instructionStatus 分组设备状态
     * @param statuses 设备执行状态列表
     * @return 四组分组结果 (completed, failed, executing, preparing)
     */
    fun groupByStatus(statuses: List<TaskDeviceStatus>): TaskStatusGroups {
        return TaskStatusGroups(
            completed = statuses.filter { it.instructionStatus == 3 },
            failed = statuses.filter { it.instructionStatus == 4 },
            executing = statuses.filter { it.instructionStatus == 2 },
            preparing = statuses.filter { it.instructionStatus == 1 }
        )
    }

    /**
     * 判断任务是否全部到达终态
     * @param statuses 设备执行状态列表
     * @return 当且仅当所有设备 instructionStatus 为 3 或 4 时返回 true
     */
    fun isAllTerminal(statuses: List<TaskDeviceStatus>): Boolean =
        statuses.all { it.instructionStatus == 3 || it.instructionStatus == 4 }
}

data class TaskStatusGroups(
    val completed: List<TaskDeviceStatus>,   // instructionStatus = 3
    val failed: List<TaskDeviceStatus>,      // instructionStatus = 4
    val executing: List<TaskDeviceStatus>,   // instructionStatus = 2
    val preparing: List<TaskDeviceStatus>    // instructionStatus = 1
)
