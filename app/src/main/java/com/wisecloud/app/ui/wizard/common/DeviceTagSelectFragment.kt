package com.wisecloud.app.ui.wizard.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentDeviceTagSelectBinding
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.visible
import com.wisecloud.app.util.visibleIf

/**
 * Reusable fragment for device tag multi-select list with search.
 *
 * Usage: Embed in wizard Step 3 to let users select device tags.
 * Call [setTags] to populate and [getSelectedTags] to retrieve selections.
 */
class DeviceTagSelectFragment : Fragment() {

    private var _binding: FragmentDeviceTagSelectBinding? = null
    private val binding get() = _binding!!

    private val allTags = mutableListOf<DeviceTag>()
    private val selectedTagIds = mutableSetOf<String>()
    private var filteredTags = listOf<DeviceTag>()
    private lateinit var adapter: TagAdapter

    data class DeviceTag(
        val id: String,
        val name: String,
        val deviceCount: Int
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeviceTagSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TagAdapter()
        binding.rvTags.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTags.adapter = adapter

        binding.etSearchTags.doAfterTextChanged { text ->
            filterTags(text?.toString().orEmpty())
        }

        updateUI()
    }

    fun setTags(tags: List<DeviceTag>) {
        allTags.clear()
        allTags.addAll(tags)
        filteredTags = allTags.toList()
        if (_binding != null) updateUI()
    }

    fun getSelectedTags(): List<DeviceTag> {
        return allTags.filter { it.id in selectedTagIds }
    }

    fun getSelectedTagIds(): List<String> = selectedTagIds.toList()

    private fun filterTags(query: String) {
        filteredTags = if (query.isBlank()) {
            allTags.toList()
        } else {
            allTags.filter { it.name.contains(query, ignoreCase = true) }
        }
        updateUI()
    }

    private fun updateUI() {
        if (_binding == null) return
        adapter.notifyDataSetChanged()
        binding.tvEmptyTags.visibleIf(filteredTags.isEmpty())
        binding.rvTags.visibleIf(filteredTags.isNotEmpty())
        binding.tvSelectedCount.text = getString(R.string.selected_tags_count, selectedTagIds.size)
        binding.tvSelectedCount.visibleIf(selectedTagIds.isNotEmpty())
    }

    private inner class TagAdapter : RecyclerView.Adapter<TagAdapter.TagViewHolder>() {

        inner class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val cbTag: CheckBox = itemView.findViewById(R.id.cbTag)
            val tvTagName: TextView = itemView.findViewById(R.id.tvTagName)
            val tvDeviceCount: TextView = itemView.findViewById(R.id.tvDeviceCount)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_device_tag, parent, false)
            return TagViewHolder(view)
        }

        override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
            val tag = filteredTags[position]
            holder.tvTagName.text = tag.name
            holder.tvDeviceCount.text = getString(R.string.device_count_format, tag.deviceCount)
            holder.cbTag.isChecked = tag.id in selectedTagIds

            val toggleSelection = {
                if (tag.id in selectedTagIds) {
                    selectedTagIds.remove(tag.id)
                } else {
                    selectedTagIds.add(tag.id)
                }
                holder.cbTag.isChecked = tag.id in selectedTagIds
                updateUI()
            }

            holder.cbTag.setOnClickListener { toggleSelection() }
            holder.itemView.setOnClickListener { toggleSelection() }
        }

        override fun getItemCount(): Int = filteredTags.size
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): DeviceTagSelectFragment = DeviceTagSelectFragment()
    }
}
