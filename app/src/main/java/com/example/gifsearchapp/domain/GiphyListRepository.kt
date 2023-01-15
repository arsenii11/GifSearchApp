package com.example.gifsearchapp.domain

interface GiphyListRepository {

    fun getGiphyList():List<GiphyItem>

    fun addGiphyItem(giphyItem: GiphyItem)

    fun getGiphyItem(giphyItemId:Int): GiphyItem
}