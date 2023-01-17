package com.example.gifsearchapp.data

import retrofit2.Call
import retrofit2.http.GET

const val API_KEY = "JucaEx7WhJV48HZHeusShY4qNZzpD5DS"

interface DataService {
    @GET("/v1/gifs/trending?api_key=$API_KEY")
    fun getGifs():Call<DataResult>
}