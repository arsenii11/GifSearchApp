package com.example.gifsearchapp.domain

import androidx.lifecycle.LiveData

class GetGiphyListUseCase(private val giphyListRepository: GiphyListRepository) {

    fun getGiphyList():LiveData<List<GIFObject>>{
      return giphyListRepository.getGiphyList()
    }

}