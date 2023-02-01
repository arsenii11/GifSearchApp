package com.example.gifsearchapp.domain

class AddGiphyItemUseCase(private val giphyListRepository: GiphyListRepository) {

    fun addGiphyItem(giphyItem: GIFObject) {
        giphyListRepository.addGiphyItem(giphyItem)
    }
}