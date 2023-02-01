package com.example.gifsearchapp.presentation.main

import androidx.recyclerview.widget.RecyclerView
import com.example.gifsearchapp.Utilities.Utility.loadImage
import com.example.gifsearchapp.data.GIFObject
import com.example.gifsearchapp.databinding.ItemGiphyBinding

class GiphyItemViewHolder(private val binding: ItemGiphyBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindGiphy(item: GIFObject) = with(binding) {
        imageGiphy.loadImage(item.images.dwImage.url)
    }
}