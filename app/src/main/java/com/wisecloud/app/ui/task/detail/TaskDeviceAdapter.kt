package com.wisecloud.app.ui.task.detail

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.TaskDeviceStatus
import com.wisecloud.app.databinding.ItemTaskDeviceBinding
import com.wisecloud.app.util.formatDateTime

class TaskDeviceAdapter : ListAdapter<TaskDeviceStatus, TaskDeviceAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTaskDeviceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemTaskDeviceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(status: TaskDeviceStatus) {
            binding.tvSn.text = status.sn
            binding.tvUpdatedAt.text = status.updatedAt?.formatDateTime() ?: ""

            val (label, colorRes) = when (status.instructionStatus) {
                3 -> itemView.context.getString(R.string.status_succeed) to R.color.status_completed
                4 -> itemView.context.getString(R.string.status_failed_label) to R.color.status_failed
                2 -> itemView.context.getString(R.string.status_executing_label) to R.color.status_in_progress
                1 -> itemView.context.getString(R.string.status_preparing_label) to R.color.status_pending
                else -> "Unknown" to R.color.status_pending
            }

            binding.tvDeviceStatus.text = label
            val color = ContextCompat.getColor(itemView.context, colorRes)
            binding.tvDeviceStatus.setTextColor(color)
            val bg = GradientDrawable().apply {
                cornerRadius = 10f
                setColor(color)
                alpha = 40
            }
            binding.tvDeviceStatus.background = bg
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TaskDeviceStatus>() {
        override fun areItemsTheSame(oldItem: TaskDeviceStatus, newItem: TaskDeviceStatus) =
            oldItem.sn == newItem.sn

        override fun areContentsTheSame(oldItem: TaskDeviceStatus, newItem: TaskDeviceStatus) =
            oldItem == newItem
    }
}
