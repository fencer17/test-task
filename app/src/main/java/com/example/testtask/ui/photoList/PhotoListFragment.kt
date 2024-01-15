package com.example.testtask.ui.photoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testtask.R
import com.example.testtask.databinding.FragmentPhotoListBinding
import com.example.testtask.ui.custom.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class PhotoListFragment: Fragment() {

    private var binding: FragmentPhotoListBinding? = null
    private val viewModel by viewModels<PhotoListViewModel>()

    private val photoListAdapter by lazy { PhotoListAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupListeners()
    }

    private fun setupListeners() {
        viewModel.albumFlow.onEach { album ->
            binding?.toolbar?.title = album?.title
            photoListAdapter.setItems(album?.items?.sortedByDescending { it.published }.orEmpty())
        }.launchIn(lifecycleScope)
    }

    private fun setupRecyclerView() {
        binding?.rvPhotos?.apply {
            val spanCount = if (resources.getBoolean(R.bool.isTablet)) WIDE_SCREEN_SPAN_COUNT else DEFAULT_SPAN_COUNT
            layoutManager = GridLayoutManager(requireContext(), spanCount)

            addItemDecoration(
                GridSpacingItemDecoration(
                    spanCount = spanCount,
                    spacing = resources.getDimensionPixelSize(R.dimen.default_margin),
                    includeEdge = true,
                    isVerticalOnly = false
                )
            )

            adapter = photoListAdapter
        }
    }

    companion object {
        const val DEFAULT_SPAN_COUNT = 1
        const val WIDE_SCREEN_SPAN_COUNT = 3
    }
}