package com.example.gifsearchapp.domain

data class GiphyItem(
    var id: Int = UNDEFINED_ID
) {

    companion object {

        const val UNDEFINED_ID = -1
    }
}
