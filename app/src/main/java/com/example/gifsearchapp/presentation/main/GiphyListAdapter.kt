package com.example.gifsearchapp.presentation.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifsearchapp.R
import com.example.gifsearchapp.Utilities.Utility.loadImage
import com.example.gifsearchapp.data.GIFObject
import com.example.gifsearchapp.databinding.ItemGiphyBinding


class GiphyListAdapter :
    PagingDataAdapter<GIFObject, GiphyListAdapter.PassengersViewHolder>(PassengersComparator) {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PassengersViewHolder {
        return PassengersViewHolder(
            ItemGiphyBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PassengersViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bindPassenger(it) }
    }

    inner class PassengersViewHolder(private val binding: ItemGiphyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindPassenger(item: GIFObject) = with(binding) {
            imageGiphy.loadImage(item.images.dwImage.url)
        }
    }

    object PassengersComparator : DiffUtil.ItemCallback<GIFObject>() {
        override fun areItemsTheSame(oldItem: GIFObject, newItem: GIFObject): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GIFObject, newItem: GIFObject): Boolean {
            return oldItem == newItem
        }
    }
}