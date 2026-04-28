package com.wisecloud.app.ui.task.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentTaskListBinding
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visible
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskListFragment : Fragment() {

    private var _binding: FragmentTaskListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TaskListViewModel by viewModels()
    private lateinit var taskAdapter: TaskListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupSearch()
        setupFilterButton()
        setupTypeFilterChips()
        setupNavigationTabs()
        setupRecyclerView()
        observeViewModel()
        viewModel.loadTasks()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            try {
                androidx.navigation.fragment.findNavController(this).navigateUp()
            } catch (e: Exception) {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }
    }

    private fun setupSearch() {
        binding.etSearch.doAfterTextChanged { text ->
            viewModel.onSearchQueryChanged(text?.toString().orEmpty())
        }
    }

    private fun setupFilterButton() {
        binding.btnFilter.setOnClickListener {
            viewModel.toggleFilterExpanded()
        }
    }

    private fun setupTypeFilterChips() {
        binding.chipTypeAll.setOnClickListener { viewModel.setTypeFilter(null) }
        binding.chipTypeOta.setOnClickListener { viewModel.setTypeFilter("ota") }
        binding.chipTypePushApp.setOnClickListener { viewModel.setTypeFilter("install") }
        binding.chipTypePushInstruction.setOnClickListener { viewModel.setTypeFilter("instruction") }
        binding.chipTypeAddDevice.setOnClickListener { viewModel.setTypeFilter("addDevice") }
        binding.chipTypeFilePush.setOnClickListener { viewModel.setTypeFilter("filepush") }
        binding.chipTypeUninstall.setOnClickListener { viewModel.setTypeFilter("uninstall") }
        binding.chipTypeSuspend.setOnClickListener { viewModel.setTypeFilter("suspend") }
    }

    private fun setupNavigationTabs() {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_all_task))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_my_following))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_partner_tasks))

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val navTab = when (tab.position) {
                    0 -> TaskListViewModel.NavTab.ALL
                    1 -> TaskListViewModel.NavTab.MY_FOLLOWING
                    2 -> TaskListViewModel.NavTab.PARTNER
                    else -> TaskListViewModel.NavTab.ALL
                }
                viewModel.setNavTab(navTab)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskListAdapter { task ->
            navigateToTaskDetail(task.traceId)
        }
        binding.rvTasks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = taskAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            taskAdapter.submitList(tasks)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            binding.layoutLoading.visibleIf(loading)
            if (loading) {
                binding.rvTasks.gone()
                binding.layoutEmpty.gone()
            }
        }

        viewModel.isEmpty.observe(viewLifecycleOwner) { empty ->
            val isLoading = viewModel.isLoading.value == true
            if (!isLoading) {
                binding.layoutEmpty.visibleIf(empty)
                if (empty) binding.rvTasks.gone() else binding.rvTasks.visible()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            message?.let { requireContext().showToast(it) }
        }

        viewModel.filterExpanded.observe(viewLifecycleOwner) { expanded ->
            binding.scrollTypeFilter.visibleIf(expanded)
        }
    }

    private fun navigateToTaskDetail(traceId: String) {
        try {
            val bundle = Bundle().apply { putString("traceId", traceId) }
            androidx.navigation.fragment.findNavController(this).navigate(
                R.id.action_taskList_to_taskDetail, bundle
            )
        } catch (e: Exception) {
            // Navigation action not yet defined — will be wired in task 22
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
