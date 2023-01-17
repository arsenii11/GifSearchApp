package com.example.gifsearchapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gifsearchapp.domain.GiphyItem
import com.example.gifsearchapp.domain.GiphyListRepository

object GifSearchAppRepoImpl : GiphyListRepository {

    private val giphyListLD = MutableLiveData<List<GiphyItem>>()
    private val giphyList = mutableListOf<GiphyItem>()

    override fun getGiphyList(): LiveData<List<GiphyItem>> {
        return giphyListLD
    }

    override fun addGiphyItem(giphyItem: GiphyItem) {
        giphyList.add(giphyItem)
        updateList()
    }

    override fun getGiphyItem(giphyItemId: Int): GiphyItem {
        return giphyList.find { it.id == giphyItemId }
            ?: throw RuntimeException("Element with id $giphyItemId not found")
    }

    private fun updateList() {
        giphyListLD.value = giphyList.toList()
    }

}