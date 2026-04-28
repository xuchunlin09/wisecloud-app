package com.wisecloud.app.ui.task.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentTaskDetailBinding
import com.wisecloud.app.util.formatDateTime
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visible
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class TaskDetailFragment : Fragment() {

    private var _binding: FragmentTaskDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TaskDetailViewModel by viewModels()
    private lateinit var deviceAdapter: TaskDeviceAdapter

    private var traceId: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        traceId = arguments?.getString("traceId").orEmpty()

        setupToolbar()
        setupDeviceStatusTabs()
        setupSnSearch()
        setupRecyclerView()
        observeViewModel()

        viewModel.loadTaskDetails(traceId)
        viewModel.startPolling(traceId)
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            try {
                findNavController().navigateUp()
            } catch (e: Exception) {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }
    }

    private fun setupDeviceStatusTabs() {
        // Completed(3), Failed(4), Executing(2), Preparing(1)
        val tabs = listOf(
            R.string.tab_completed to 3,
            R.string.tab_failed to 4,
            R.string.tab_executing to 2,
            R.string.tab_preparing to 1
        )
        tabs.forEach { (labelRes, _) ->
            binding.tabDeviceStatus.addTab(
                binding.tabDeviceStatus.newTab().setText(labelRes)
            )
        }

        binding.tabDeviceStatus.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val statusValue = when (tab.position) {
                    0 -> 3 // Completed
                    1 -> 4 // Failed
                    2 -> 2 // Executing
                    3 -> 1 // Preparing
                    else -> 3
                }
                viewModel.setTab(statusValue)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun setupSnSearch() {
        binding.etSnSearch.doAfterTextChanged { text ->
            viewModel.onSnSearchChanged(text?.toString().orEmpty())
        }
    }

    private fun setupRecyclerView() {
        deviceAdapter = TaskDeviceAdapter()
        binding.rvDevices.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = deviceAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.taskDetail.observe(viewLifecycleOwner) { detail ->
            binding.toolbar.title = detail.taskName
            binding.tvTaskName.text = detail.taskName
            binding.tvAppName.text = detail.taskType
        }

        viewModel.progress.observe(viewLifecycleOwner) { progress ->
            binding.tvTotalDevices.text = progress.totalCount.toString()
            binding.tvValidDevices.text = progress.completedCount.toString()
            binding.tvInvalidDevices.text = progress.failedCount.toString()

            // Update status tag
            val statusText: String
            val statusColor: Int
            if (progress.totalCount > 0 && progress.completedCount + progress.failedCount >= progress.totalCount) {
                if (progress.failedCount == 0) {
                    statusText = getString(R.string.tab_completed)
                    statusColor = R.color.status_completed
                } else {
                    statusText = getString(R.string.tab_failed)
                    statusColor = R.color.status_failed
                }
            } else if (progress.executingCount > 0 || progress.completedCount > 0 || progress.failedCount > 0) {
                statusText = getString(R.string.tab_executing)
                statusColor = R.color.status_in_progress
            } else {
                statusText = getString(R.string.tab_preparing)
                statusColor = R.color.status_pending
            }
            binding.tvStatusTag.text = statusText
            val bg = android.graphics.drawable.GradientDrawable().apply {
                cornerRadius = 12f
                setColor(ContextCompat.getColor(requireContext(), statusColor))
            }
            binding.tvStatusTag.background = bg

            // Update tab badges with counts
            updateTabBadges(progress)
        }

        viewModel.statusGroups.observe(viewLifecycleOwner) { groups ->
            // Tab text with counts
            setTabText(0, getString(R.string.tab_completed), groups.completed.size)
            setTabText(1, getString(R.string.tab_failed), groups.failed.size)
            setTabText(2, getString(R.string.tab_executing), groups.executing.size)
            setTabText(3, getString(R.string.tab_preparing), groups.preparing.size)
        }

        viewModel.filteredDevices.observe(viewLifecycleOwner) { devices ->
            deviceAdapter.submitList(devices)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            binding.progressBar.visibleIf(loading)
        }

        viewModel.currentPage.observe(viewLifecycleOwner) { page ->
            val total = viewModel.totalPages.value ?: 1
            binding.tvPageInfo.text = getString(R.string.page_info_format, page, total)
        }

        viewModel.totalPages.observe(viewLifecycleOwner) { total ->
            val page = viewModel.currentPage.value ?: 1
            binding.tvPageInfo.text = getString(R.string.page_info_format, page, total)
            binding.layoutPagination.visibleIf(total > 1)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            message?.let { requireContext().showToast(it) }
        }
    }

    private fun updateTabBadges(progress: com.wisecloud.app.util.TaskProgressUtil.TaskProgress) {
        // Already handled via statusGroups observer
    }

    private fun setTabText(position: Int, label: String, count: Int) {
        binding.tabDeviceStatus.getTabAt(position)?.text = "$label ($count)"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.stopPolling()
        _binding = null
    }
}
