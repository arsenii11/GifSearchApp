package com.example.gifsearchapp.presentation.main

import androidx.recyclerview.widget.DiffUtil
import com.example.gifsearchapp.domain.GIFObject

object GiphyItemComparator: DiffUtil.ItemCallback<com.example.gifsearchapp.data.GIFObject>() {

    override fun areItemsTheSame(oldItem: com.example.gifsearchapp.data.GIFObject, newItem: com.example.gifsearchapp.data.GIFObject): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: com.example.gifsearchapp.data.GIFObject, newItem: com.example.gifsearchapp.data.GIFObject): Boolean {
        return oldItem == newItem
    }
}