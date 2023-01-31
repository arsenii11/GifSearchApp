package com.example.gifsearchapp.domain

import androidx.paging.PagingSource
import com.example.gifsearchapp.data.DataResult
import com.example.gifsearchapp.data.DataService
import com.example.gifsearchapp.data.GifResponse
import com.example.gifsearchapp.data.Links
import retrofit2.Call

class PagingSource(private val api: DataService):PagingSource<Int, GiphyItem>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GiphyItem> {


        return try {
            val nextPageNumber = params.key ?: 0
            val response: GifResponse = api.getGifs(Links.API_KEY,nextPageNumber ,10)

            LoadResult.Page(
                data = response.res,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < response.Pagination.total_count) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}