package com.example.gifsearchapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.gifsearchapp.data.DataService
import com.example.gifsearchapp.data.GifSearchAppRepoImpl
import com.example.gifsearchapp.domain.GetGiphyListUseCase
import com.example.gifsearchapp.domain.PagingSource


class MainViewModel(
        private val api: DataService,
        private val request_text: String
    ) : ViewModel() {
        val passengers = Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 2), pagingSourceFactory = {
           PagingSource(api, request_text)
        }).flow.cachedIn(viewModelScope)
    }
