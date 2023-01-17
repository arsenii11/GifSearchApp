package com.example.gifsearchapp.presentation.main

import androidx.lifecycle.ViewModel
import com.example.gifsearchapp.data.GifSearchAppRepoImpl
import com.example.gifsearchapp.domain.GetGiphyListUseCase

class MainViewModel : ViewModel() {

    private val repository = GifSearchAppRepoImpl

    private val getGiphyListUseCase = GetGiphyListUseCase(repository)

    val giphyList = getGiphyListUseCase.getGiphyList()

}