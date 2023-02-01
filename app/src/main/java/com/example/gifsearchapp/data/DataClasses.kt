package com.example.gifsearchapp.data

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data") val res: List<DataObject>,
    @SerializedName("pagination") val pagination: Pagination
)

class Pagination(
    val offset: Int,
    val total_count: Int,
    val count: Int
)

data class DataObject(
    @SerializedName("images") val images: DataImage
)

data class DataImage(
    @SerializedName("downsized_medium") val dwImage: dwImage
)

data class dwImage(
    val url:String
)
