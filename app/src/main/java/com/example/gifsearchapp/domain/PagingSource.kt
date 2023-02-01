package com.example.gifsearchapp.domain

import androidx.paging.PagingSource
import com.example.gifsearchapp.data.DataResult
import com.example.gifsearchapp.data.DataService
import retrofit2.Call

class PagingSource(private val api: DataService):PagingSource<Int, GiphyItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GiphyItem> {
        TODO("Not yet implemented")
    }

}