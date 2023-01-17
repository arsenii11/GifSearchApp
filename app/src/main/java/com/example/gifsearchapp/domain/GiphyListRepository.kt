package com.example.gifsearchapp.domain

import androidx.lifecycle.LiveData

interface GiphyListRepository {

    fun getGiphyList(): LiveData<List<GiphyItem>>

    fun addGiphyItem(giphyItem: GiphyItem)

    fun getGiphyItem(giphyItemId:Int): GiphyItem
}