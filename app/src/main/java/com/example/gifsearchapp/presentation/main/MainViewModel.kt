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

class MainViewModel(private val api: DataService) : ViewModel() {

    private val repository = GifSearchAppRepoImpl

    private val getGiphyListUseCase = GetGiphyListUseCase(repository)

    val giphyList = getGiphyListUseCase.getGiphyList()

    val giphies = Pager(config = PagingConfig(10,2), pagingSourceFactory = {
        PagingSource(api)
    }).flow.cachedIn(viewModelScope)

    private val _errorInput = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInput

    fun validateInput(name: String): Boolean {
        var result = true
        if (name.isBlank()) {
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInput.value = false
    }


}