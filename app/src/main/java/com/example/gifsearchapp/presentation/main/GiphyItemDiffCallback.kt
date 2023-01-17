package com.example.gifsearchapp.presentation.main

import androidx.recyclerview.widget.DiffUtil
import com.example.gifsearchapp.domain.GiphyItem

class GiphyItemDiffCallback: DiffUtil.ItemCallback<GiphyItem>() {

    override fun areItemsTheSame(oldItem: GiphyItem, newItem: GiphyItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GiphyItem, newItem: GiphyItem): Boolean {
        return oldItem == newItem
    }
}
