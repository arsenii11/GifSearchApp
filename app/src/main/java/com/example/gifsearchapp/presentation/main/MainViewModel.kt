package com.example.gifsearchapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gifsearchapp.data.GifSearchAppRepoImpl
import com.example.gifsearchapp.domain.GetGiphyListUseCase

class MainViewModel : ViewModel() {

    private val repository = GifSearchAppRepoImpl

    private val getGiphyListUseCase = GetGiphyListUseCase(repository)

    val giphyList = getGiphyListUseCase.getGiphyList()

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
