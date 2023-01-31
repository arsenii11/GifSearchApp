package com.example.gifsearchapp.data

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data") val res: List<DataObject>
)
data class DataPagination(
    @SerializedName("pagination") val page: List<InfoResponse>
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
