package com.example.gifsearchapp.presentation.main


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.gifsearchapp.R
import com.example.gifsearchapp.data.DataObject
import com.example.gifsearchapp.data.DataResult
import com.example.gifsearchapp.data.DataService
import com.example.gifsearchapp.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.giphy.com/v1/"
const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var giphyListAdapter: GiphyListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.giphyList.observe(this) {
            giphyListAdapter.submitList(it)
        }


        val gifs = mutableListOf<DataObject>()

        setupRecyclerView(gifs)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retroService = retrofit.create(DataService::class.java)
        retroService.getGifs().enqueue(object : Callback<DataResult?> {
            override fun onResponse(call: Call<DataResult?>, response: Response<DataResult?>) {
                val body = response.body()
                if (body == null) {
                    Log.d(TAG, "onResponse: No response...")
                }

                //adding to list
                gifs.addAll(body!!.res)
                giphyListAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<DataResult?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

   private fun setupRecyclerView(gifs:MutableList<DataObject>) {
       val rvGiphyList = findViewById<RecyclerView>(R.id.recyclerView)

       giphyListAdapter = GiphyListAdapter(this, gifs )

        with(rvGiphyList){
        adapter = giphyListAdapter
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recycledViewPool.setMaxRecycledViews(
            GiphyListAdapter.VIEW_TYPE_ENABLED,
            GiphyListAdapter.MAX_POOL_SIZE
        )}

    }

}