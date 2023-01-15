package com.example.gifsearchapp.data

import com.example.gifsearchapp.domain.GiphyItem
import com.example.gifsearchapp.domain.GiphyListRepository

object GifSearchAppRepoImpl : GiphyListRepository {

    private val giphyList = mutableListOf<GiphyItem>()

    override fun getGiphyList(): List<GiphyItem> {
        return giphyList.toMutableList()
    }

    override fun addGiphyItem(giphyItem: GiphyItem) {
        giphyList.add(giphyItem)
    }

    override fun getGiphyItem(giphyItemId: Int): GiphyItem {
       return giphyList.find { it.id == giphyItemId } ?: throw RuntimeException("Element with id $giphyItemId not found")
    }

}