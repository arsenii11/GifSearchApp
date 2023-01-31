package com.example.gifsearchapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gifsearchapp.data.DataService

class MainViewModelFactory(
    private val api: DataService
    ) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(api) as T
    }
}