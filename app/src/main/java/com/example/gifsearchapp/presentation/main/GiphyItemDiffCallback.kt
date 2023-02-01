package com.example.gifsearchapp.presentation.main

import androidx.recyclerview.widget.DiffUtil
import com.example.gifsearchapp.domain.GIFObject

object GiphyItemDiffCallback: DiffUtil.ItemCallback<GIFObject>() {

    override fun areItemsTheSame(oldItem: GIFObject, newItem: GIFObject): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GIFObject, newItem: GIFObject): Boolean {
        return oldItem == newItem
    }
}
