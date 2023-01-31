package com.example.gifsearchapp.presentation.main

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.gifsearchapp.R
import com.example.gifsearchapp.data.DataObject
import com.example.gifsearchapp.domain.GiphyItem

class GiphyListAdapter(private val context: Context, private val gifs:List<DataObject>): PagingDataAdapter<GiphyItem, GiphyItemViewHolder>(GiphyItemDiffCallback()) {

    var count = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyItemViewHolder {

      val view = (LayoutInflater.from(parent.context).inflate(R.layout.item_giphy,parent,false))
        return  GiphyItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: GiphyItemViewHolder, position: Int) {

       val data = gifs[position]

        Glide.with(context).load(data.images.ogImage.url)
            .into(viewHolder.giphyImage)
    }

    override fun getItemCount(): Int {
        return gifs.size
    }

    companion object {
        fun submitData(pagedData: PagingData<GiphyItem>) {

        }

        const val VIEW_TYPE_ENABLED = 100
        const val MAX_POOL_SIZE = 20
    }
}