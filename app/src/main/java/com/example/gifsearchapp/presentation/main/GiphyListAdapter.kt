package com.example.gifsearchapp.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.gifsearchapp.data.GIFObject
import com.example.gifsearchapp.databinding.ItemGiphyBinding


class GiphyListAdapter : PagingDataAdapter<GIFObject, GiphyItemViewHolder>(GiphyItemComparator) {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GiphyItemViewHolder {
        return GiphyItemViewHolder(
            ItemGiphyBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GiphyItemViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bindGiphy(it) }
    }


}