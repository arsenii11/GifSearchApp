package com.example.gifsearchapp.domain

import android.widget.Toast
import androidx.lifecycle.LiveData

class GetGiphyListUseCase(private val giphyListRepository: GiphyListRepository) {

    fun getGiphyList():LiveData<List<GiphyItem>>{
      return giphyListRepository.getGiphyList()
    }

}