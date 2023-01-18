package com.example.gifsearchapp.data

import com.example.gifsearchapp.data.Links.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface DataService {
    @GET("/v1/gifs/search?")
    fun getGifs(
        @Query("api_key") access_key: String = Links.API_KEY,
        @Query("q") f: String ,
        @Query("lang") language: String = "en",
    ):Call<DataResult>
}