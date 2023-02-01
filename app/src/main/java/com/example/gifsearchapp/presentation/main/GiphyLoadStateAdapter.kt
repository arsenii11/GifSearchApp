package com.example.gifsearchapp.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gifsearchapp.Utilities.Utility.visible
import com.example.gifsearchapp.databinding.ItemLoadingStateBinding

class GiphyLoadStateAdapter (
    private val retry: () -> Unit
) : LoadStateAdapter<GiphyLoadStateAdapter.GiphyLoadStateViewHolder>() {

    inner class GiphyLoadStateViewHolder(
        private val binding: ItemLoadingStateBinding,
        private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.textViewError.text = loadState.error.localizedMessage
            }

            binding.progressbar.visible(loadState is LoadState.Loading)
            binding.buttonRetry.visible(loadState is LoadState.Error)
            binding.textViewError.visible(loadState is LoadState.Error)
            binding.buttonRetry.setOnClickListener {
                retry()
            }

            binding.progressbar.visibility = View.VISIBLE
        }
    }

    override fun onBindViewHolder(holder: GiphyLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = GiphyLoadStateViewHolder(
        ItemLoadingStateBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        retry
    )
}