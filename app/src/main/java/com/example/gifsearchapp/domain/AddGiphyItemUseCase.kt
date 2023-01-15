package com.example.gifsearchapp.domain

class AddGiphyItemUseCase(private val giphyListRepository: GiphyListRepository) {

    fun addGiphyItem(giphyItem: GiphyItem) {
        giphyListRepository.addGiphyItem(giphyItem)
    }
}