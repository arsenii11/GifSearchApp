package com.example.gifsearchapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gifsearchapp.R
import com.example.gifsearchapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}