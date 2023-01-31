package com.example.gifsearchapp.data

import com.example.gifsearchapp.domain.GiphyItem
import com.google.gson.annotations.SerializedName
import retrofit2.Callback

class GifResponse (
    @SerializedName("data") val res: List<GiphyItem>,
    val Pagination: InfoResponse
    ) {
}
