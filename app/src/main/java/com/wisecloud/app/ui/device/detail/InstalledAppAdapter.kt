package com.wisecloud.app.ui.device.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.data.model.response.InstalledApp
import com.wisecloud.app.databinding.ItemInstalledAppGridBinding
import com.wisecloud.app.databinding.ItemInstalledAppListBinding

/**
 * Grid mode adapter for installed apps (icon + name, 4-column grid)
 */
class InstalledAppGridAdapter :
    ListAdapter<InstalledApp, InstalledAppGridAdapter.ViewHolder>(AppDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemInstalledAppGridBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemInstalledAppGridBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(app: InstalledApp) {
            binding.tvAppName.text = app.appName
            // App icon placeholder — first letter of app name
            binding.tvAppIcon.text = app.appName.firstOrNull()?.uppercase() ?: "A"
        }
    }
}

/**
 * List mode adapter for installed apps (name, package, version — used in BottomSheet)
 */
class InstalledAppListAdapter :
    ListAdapter<InstalledApp, InstalledAppListAdapter.ViewHolder>(AppDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemInstalledAppListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemInstalledAppListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(app: InstalledApp) {
            binding.tvAppName.text = app.appName
            binding.tvPackageName.text = app.appPackage
            binding.tvVersionName.text = app.versionName
        }
    }
}

private object AppDiffCallback : DiffUtil.ItemCallback<InstalledApp>() {
    override fun areItemsTheSame(oldItem: InstalledApp, newItem: InstalledApp) =
        oldItem.appPackage == newItem.appPackage

    override fun areContentsTheSame(oldItem: InstalledApp, newItem: InstalledApp) =
        oldItem == newItem
}
