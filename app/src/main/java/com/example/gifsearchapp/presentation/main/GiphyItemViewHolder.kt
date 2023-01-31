package com.example.gifsearchapp.presentation.main

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.gifsearchapp.R

class GiphyItemViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    val giphyImage: ImageView = view.findViewById<ImageView>(R.id.image_giphy)
}