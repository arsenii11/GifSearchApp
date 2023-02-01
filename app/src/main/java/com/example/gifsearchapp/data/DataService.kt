package com.example.gifsearchapp.data

import com.example.gifsearchapp.data.Links.Companion.API_KEY
import com.example.gifsearchapp.data.Links.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



interface DataService {
    @GET("/v1/gifs/search?")
    suspend fun getPassengersData(
        @Query("api_key") access_key: String = API_KEY,
        @Query("q") f: String,
        @Query("offset") page: Int,
        @Query("lang") language: String = "en",
        @Query("limit") size: Int = 10

    ): GiphyResponse

    companion object {

        private const val BASE_URL ="https://api.giphy.com/v1/"

        operator fun invoke(): DataService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(logging)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataService::class.java)
    }
}