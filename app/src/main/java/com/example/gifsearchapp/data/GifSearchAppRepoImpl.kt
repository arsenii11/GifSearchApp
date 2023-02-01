package com.example.gifsearchapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gifsearchapp.domain.GIFObject
import com.example.gifsearchapp.domain.GiphyListRepository

object GifSearchAppRepoImpl : GiphyListRepository {

    private val giphyListLD = MutableLiveData<List<GIFObject>>()
    private val giphyList = mutableListOf<GIFObject>()

    override fun getGiphyList(): LiveData<List<GIFObject>> {
        return giphyListLD
    }

    override fun addGiphyItem(giphyItem: GIFObject) {
        giphyList.add(giphyItem)
        updateList()
    }

    override fun getGiphyItem(giphyItemId: Int): GIFObject {
        return giphyList.find { it.id == giphyItemId }
            ?: throw RuntimeException("Element with id $giphyItemId not found")
    }

    private fun updateList() {
        giphyListLD.value = giphyList.toList()
    }

}