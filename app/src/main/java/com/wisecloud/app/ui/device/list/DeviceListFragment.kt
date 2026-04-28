package com.wisecloud.app.ui.device.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentDeviceListBinding
import com.wisecloud.app.util.DeviceFilterUtil
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visible
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeviceListFragment : Fragment() {

    private var _binding: FragmentDeviceListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DeviceListViewModel by viewModels()
    private lateinit var deviceAdapter: DeviceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeviceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupRecyclerView()
        setupSearch()
        setupFilterChips()
        setupSwipeRefresh()
        observeViewModel()

        viewModel.refresh()
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

    private fun setupRecyclerView() {
        deviceAdapter = DeviceListAdapter { device ->
            navigateToDeviceDetail(device.sn)
        }

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvDevices.apply {
            this.layoutManager = layoutManager
            adapter = deviceAdapter
        }

        // Infinite scroll pagination
        binding.rvDevices.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy <= 0) return

                val totalItemCount = layoutManager.itemCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItem >= totalItemCount - 3) {
                    viewModel.loadNextPage()
                }
            }
        })
    }

    private fun setupSearch() {
        binding.etSearch.doAfterTextChanged { text ->
            viewModel.onSearchQueryChanged(text?.toString().orEmpty())
        }
    }

    private fun setupFilterChips() {
        binding.chipAll.setOnClickListener {
            viewModel.setOnlineFilter(DeviceFilterUtil.OnlineFilter.ALL)
        }
        binding.chipOnline.setOnClickListener {
            viewModel.setOnlineFilter(DeviceFilterUtil.OnlineFilter.ONLINE)
        }
        binding.chipOffline.setOnClickListener {
            viewModel.setOnlineFilter(DeviceFilterUtil.OnlineFilter.OFFLINE)
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setColorSchemeResources(R.color.primary)
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    private fun observeViewModel() {
        viewModel.devices.observe(viewLifecycleOwner) { devices ->
            deviceAdapter.submitList(devices)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            binding.progressBar.visibleIf(loading)
        }

        viewModel.isRefreshing.observe(viewLifecycleOwner) { refreshing ->
            binding.swipeRefresh.isRefreshing = refreshing
        }

        viewModel.isEmpty.observe(viewLifecycleOwner) { empty ->
            binding.layoutEmpty.visibleIf(empty)
            if (empty) {
                binding.rvDevices.gone()
            } else {
                binding.rvDevices.visible()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            message?.let {
                requireContext().showToast(it)
            }
        }

        viewModel.onlineFilter.observe(viewLifecycleOwner) { filter ->
            when (filter) {
                DeviceFilterUtil.OnlineFilter.ALL -> binding.chipAll.isChecked = true
                DeviceFilterUtil.OnlineFilter.ONLINE -> binding.chipOnline.isChecked = true
                DeviceFilterUtil.OnlineFilter.OFFLINE -> binding.chipOffline.isChecked = true
                null -> { /* no-op */ }
            }
        }
    }

    private fun navigateToDeviceDetail(sn: String) {
        try {
            val bundle = Bundle().apply { putString("sn", sn) }
            androidx.navigation.fragment.findNavController(this).navigate(
                R.id.action_deviceList_to_deviceDetail, bundle
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
