package com.example.gifsearchapp.data

import com.google.gson.annotations.SerializedName

data class GiphyResponse(
    @SerializedName("data") val data: List<GIFObject>,
    @SerializedName("pagination") val pagination: Pagination
)

class Pagination(
    val offset: Int,
    val total_count: Int,
    val count: Int
)

data class GIFObject(
    val id: String,
    @SerializedName("images") val images: DataImage
)

data class DataImage(
    @SerializedName("downsized_medium") val dwImage: dwImage
)

data class dwImage(
    val url:String
)
