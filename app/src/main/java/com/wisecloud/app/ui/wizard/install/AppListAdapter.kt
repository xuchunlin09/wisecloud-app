package com.wisecloud.app.ui.wizard.install

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.AppVersion
import com.wisecloud.app.data.model.response.ApplicationInfo

/**
 * Adapter for displaying applications with expandable version selection.
 */
class AppListAdapter(
    private val onAppSelected: (ApplicationInfo) -> Unit,
    private val onVersionSelected: (AppVersion) -> Unit
) : ListAdapter<ApplicationInfo, AppListAdapter.AppViewHolder>(AppDiffCallback()) {

    private var selectedAppIndex = -1

    inner class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rbApp: RadioButton = itemView.findViewById(R.id.rbApp)
        val tvAppName: TextView = itemView.findViewById(R.id.tvAppName)
        val tvAppDesc: TextView = itemView.findViewById(R.id.tvAppDesc)
        val layoutVersions: LinearLayout = itemView.findViewById(R.id.layoutVersions)
        val rvVersions: RecyclerView = itemView.findViewById(R.id.rvVersions)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app_select, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = getItem(position)
        holder.tvAppName.text = app.appName
        holder.tvAppDesc.text = app.appDescription ?: app.appPackage
        holder.rbApp.isChecked = position == selectedAppIndex

        val isExpanded = position == selectedAppIndex
        holder.layoutVersions.visibility = if (isExpanded) View.VISIBLE else View.GONE

        if (isExpanded && app.versions.isNotEmpty()) {
            holder.rvVersions.layoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(holder.itemView.context)
            holder.rvVersions.adapter = VersionAdapter(app.versions) { version ->
                onVersionSelected(version)
            }
        }

        val selectAction = {
            val prev = selectedAppIndex
            selectedAppIndex = holder.bindingAdapterPosition
            if (prev >= 0) notifyItemChanged(prev)
            notifyItemChanged(selectedAppIndex)
            onAppSelected(app)
        }

        holder.rbApp.setOnClickListener { selectAction() }
        holder.itemView.setOnClickListener { selectAction() }
    }

    class AppDiffCallback : DiffUtil.ItemCallback<ApplicationInfo>() {
        override fun areItemsTheSame(a: ApplicationInfo, b: ApplicationInfo) = a.appPackage == b.appPackage
        override fun areContentsTheSame(a: ApplicationInfo, b: ApplicationInfo) = a == b
    }
}

private class VersionAdapter(
    private val versions: List<AppVersion>,
    private val onSelected: (AppVersion) -> Unit
) : RecyclerView.Adapter<VersionAdapter.VH>() {

    private var selectedIndex = -1

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rbVersion: RadioButton = itemView.findViewById(R.id.rbVersion)
        val tvVersion: TextView = itemView.findViewById(R.id.tvVersionNumber)
        val tvSize: TextView = itemView.findViewById(R.id.tvFileSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app_version, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val version = versions[position]
        holder.tvVersion.text = version.versionNumber
        holder.tvSize.text = formatFileSize(version.fileSize)
        holder.rbVersion.isChecked = position == selectedIndex

        val select = {
            val prev = selectedIndex
            selectedIndex = holder.bindingAdapterPosition
            if (prev >= 0) notifyItemChanged(prev)
            notifyItemChanged(selectedIndex)
            onSelected(version)
        }
        holder.rbVersion.setOnClickListener { select() }
        holder.itemView.setOnClickListener { select() }
    }

    override fun getItemCount() = versions.size

    private fun formatFileSize(bytes: Long): String {
        return when {
            bytes >= 1_048_576 -> String.format("%.1f MB", bytes / 1_048_576.0)
            bytes >= 1024 -> String.format("%.1f KB", bytes / 1024.0)
            else -> "$bytes B"
        }
    }
}
