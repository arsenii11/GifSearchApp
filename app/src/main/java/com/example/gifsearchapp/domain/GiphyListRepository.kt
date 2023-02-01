package com.example.gifsearchapp.domain

import androidx.lifecycle.LiveData

interface GiphyListRepository {

    fun getGiphyList(): LiveData<List<GIFObject>>

    fun addGiphyItem(giphyItem: GIFObject)

    fun getGiphyItem(giphyItemId:Int): GIFObject
}