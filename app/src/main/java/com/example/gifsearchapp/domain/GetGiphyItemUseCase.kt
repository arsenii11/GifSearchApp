package com.example.gifsearchapp.domain

class GetGiphyItemUseCase(private val giphyListRepository: GiphyListRepository) {

    fun getGiphyItem(giphyItemId:Int): GIFObject{
       return giphyListRepository.getGiphyItem(giphyItemId)
    }
}