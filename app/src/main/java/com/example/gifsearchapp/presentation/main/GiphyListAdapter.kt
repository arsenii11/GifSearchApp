package com.example.gifsearchapp.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifsearchapp.R
import com.example.gifsearchapp.data.DataObject

class GiphyListAdapter(val context: MainActivity, private val gifs:List<DataObject>): RecyclerView.Adapter<GiphyItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyItemViewHolder {
        return  GiphyItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_giphy,parent,false))
    }

    override fun onBindViewHolder(holder: GiphyItemViewHolder, position: Int) {
       val data = gifs[position]

        Glide.with(context).load(data.images.ogImage.url)
            .into(holder.tvImage)
    }

    override fun getItemCount(): Int {
        return gifs.size
    }
}