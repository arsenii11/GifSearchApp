package com.example.gifsearchapp.domain

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gifsearchapp.data.DataService
import com.example.gifsearchapp.data.GIFObject
import com.example.gifsearchapp.data.GiphyResponse
import com.example.gifsearchapp.data.Links.Companion.API_KEY
import retrofit2.Call

class PagingSource(private val api: DataService, private val request_text: String):PagingSource<Int, GIFObject>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GIFObject> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response: GiphyResponse = api.getPassengersData(API_KEY,request_text, nextPageNumber)



            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < response.pagination.total_count) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    @ExperimentalPagingApi
    override fun getRefreshKey(state: PagingState<Int, GIFObject>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }
}