package com.wisecloud.app.ui.device.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.DeviceSummary
import com.wisecloud.app.databinding.ItemDeviceBinding
import com.wisecloud.app.util.formatDateTime

class DeviceListAdapter(
    private val onItemClick: (DeviceSummary) -> Unit
) : ListAdapter<DeviceSummary, DeviceListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDeviceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemDeviceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(device: DeviceSummary) {
            binding.tvSn.text = device.sn
            binding.tvDeviceType.text = device.deviceType
            binding.tvLastOnlineTime.text = device.lastOnlineTime.formatDateTime()

            val isOnline = device.onlineStatus == 1
            binding.tvOnlineStatus.text = if (isOnline) {
                itemView.context.getString(R.string.status_online)
            } else {
                itemView.context.getString(R.string.status_offline)
            }
            binding.tvOnlineStatus.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    if (isOnline) R.color.online else R.color.offline
                )
            )
            binding.viewStatusDot.setBackgroundColor(
                ContextCompat.getColor(
                    itemView.context,
                    if (isOnline) R.color.online else R.color.offline
                )
            )

            itemView.setOnClickListener { onItemClick(device) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DeviceSummary>() {
        override fun areItemsTheSame(oldItem: DeviceSummary, newItem: DeviceSummary) =
            oldItem.sn == newItem.sn

        override fun areContentsTheSame(oldItem: DeviceSummary, newItem: DeviceSummary) =
            oldItem == newItem
    }
}
