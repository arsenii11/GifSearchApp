package com.example.gifsearchapp.domain

import android.widget.Toast

class GetGiphyListUseCase(private val giphyListRepository: GiphyListRepository) {

    fun getGiphyList():List<GiphyItem>{
      return giphyListRepository.getGiphyList()
    }

}