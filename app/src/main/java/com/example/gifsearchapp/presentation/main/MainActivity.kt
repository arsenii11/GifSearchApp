package com.example.gifsearchapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gifsearchapp.R
import com.example.gifsearchapp.databinding.ActivityMainBinding
import com.example.gifsearchapp.domain.GiphyItem
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var giphyListAdapter: GiphyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        val rvGiphyList = binding.recyclerView
        with(rvGiphyList){
            giphyListAdapter = GiphyListAdapter()
        }


    }

}