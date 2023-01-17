package com.example.gifsearchapp.data

import com.example.gifsearchapp.data.Links.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET


interface DataService {
    @GET("/v1/gifs/search?api_key=$API_KEY&q=cheeseburgers&lang=en")
    fun getGifs():Call<DataResult>
}