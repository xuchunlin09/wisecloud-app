package com.wisecloud.app.ui.task.list

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.TaskSummary
import com.wisecloud.app.databinding.ItemTaskBinding
import com.wisecloud.app.util.formatDateTime

class TaskListAdapter(
    private val onItemClick: (TaskSummary) -> Unit
) : ListAdapter<TaskSummary, TaskListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemTaskBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(task: TaskSummary) {
            binding.tvTaskName.text = task.taskName
            binding.tvCreatedAt.text = task.createdAt.formatDateTime()
            binding.tvCreatedBy.text = task.createdBy ?: ""
            binding.tvProgress.text = task.progress

            // Task type label
            binding.tvTaskType.text = getTypeLabel(task.taskType)
            val typeColor = getTypeColor(task)
            val bg = GradientDrawable().apply {
                cornerRadius = 12f
                setColor(ContextCompat.getColor(itemView.context, typeColor))
            }
            binding.tvTaskType.background = bg

            // Progress bar
            val total = task.deviceCount
            val completed = task.completedCount
            if (total > 0) {
                binding.progressBar.max = total
                binding.progressBar.progress = completed
            } else {
                binding.progressBar.max = 1
                binding.progressBar.progress = 0
            }

            itemView.setOnClickListener { onItemClick(task) }
        }

        private fun getTypeLabel(taskType: String): String = when (taskType) {
            "install" -> itemView.context.getString(R.string.task_type_install)
            "uninstall" -> itemView.context.getString(R.string.task_type_uninstall)
            "ota" -> itemView.context.getString(R.string.task_type_ota)
            "instruction" -> itemView.context.getString(R.string.task_type_instruction)
            "wiseos" -> itemView.context.getString(R.string.task_type_wiseos)
            "filepush" -> itemView.context.getString(R.string.task_type_filepush)
            else -> taskType
        }

        private fun getTypeColor(task: TaskSummary): Int {
            val total = task.deviceCount
            val completed = task.completedCount
            val failed = task.failedCount
            return when {
                total > 0 && completed + failed >= total && failed == 0 -> R.color.status_completed
                total > 0 && completed + failed >= total && failed > 0 -> R.color.status_failed
                completed > 0 || failed > 0 -> R.color.status_in_progress
                else -> R.color.status_pending
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TaskSummary>() {
        override fun areItemsTheSame(oldItem: TaskSummary, newItem: TaskSummary) =
            oldItem.traceId == newItem.traceId

        override fun areContentsTheSame(oldItem: TaskSummary, newItem: TaskSummary) =
            oldItem == newItem
    }
}
