package com.example.gifsearchapp.presentation.main


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gifsearchapp.R
import com.example.gifsearchapp.data.*
import com.example.gifsearchapp.data.Links.Companion.API_KEY
import com.example.gifsearchapp.data.Links.Companion.BASE_URL
import com.example.gifsearchapp.data.Utility.background
import com.example.gifsearchapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var giphyListAdapter: GiphyListAdapter
    private lateinit var mainViewModel:MainViewModel
    private val gifs = mutableListOf<DataObject>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        if (!Utility.isNetworkAvailable(this)) showSnackbar("Internet unavailable")
        else{
            setupRecyclerView(gifs)
            setupView()
            //setupTextWatcher(binding, gifs)
        }
    }

    private fun setupViewModel() {
        val factory = MainViewModelFactory(DataService())
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private fun setupView() {
        lifecycleScope.launch {
            mainViewModel.giphies.collectLatest { giphiesData ->
                GiphyListAdapter.submitData(giphiesData)
            }
        }
    }


    fun setupTextWatcher(binding: ActivityMainBinding, gifs: MutableList<DataObject>) {
        val inputGiphy = binding.giphySearchInput
        inputGiphy.addTextChangedListener(
            object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                private var timer = Timer()
                private val DELAY: Long = 1000 // Milliseconds

                override fun afterTextChanged(s: Editable) {
                    timer.cancel()
                    timer = Timer()
                    timer.schedule(
                        object : TimerTask() {
                            override fun run() {
                                if(viewModel.validateInput(inputGiphy.text.toString()) ){
                                runOnUiThread {
                                    gifs.clear()
                                    //retrofitRequest(gifs, inputGiphy.text.toString())
                                    setupRecyclerView(gifs)
                                    Utility.hideKeyboard(this@MainActivity)
                                }
                                }
                            }
                        },
                        DELAY
                    )
                }
            }
        )
    }



  /* fun retrofitRequest(gifs: MutableList<DataObject>, request: String) {

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retroService = retrofit.create(DataService::class.java)
        retroService.getGifs(API_KEY, request).enqueue(object : Callback<GifResponse?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<GifResponse?>, response: Response<GifResponse?>) {
                val body = response.body()
                if (body == null) {
                    Log.d(TAG, "onResponse: No response...")
                }

                //adding to list
                gifs.addAll(body!!.res)
                giphyListAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<GifResponse?>, t: Throwable) {
                showSnackbar("network failure ")
            }
        })
    }*/


    @SuppressLint("UseRequireInsteadOfGet")
    fun showSnackbar(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .background(ContextCompat.getColor(this!!, R.color.red))
            .show()
    }

    private fun setupRecyclerView(gifs: MutableList<DataObject>) {
        val rvGiphyList = findViewById<RecyclerView>(R.id.recyclerView)

        giphyListAdapter = GiphyListAdapter(this, gifs)

        with(rvGiphyList) {
            adapter = giphyListAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            recycledViewPool.setMaxRecycledViews(
                GiphyListAdapter.VIEW_TYPE_ENABLED,
                GiphyListAdapter.MAX_POOL_SIZE
            )
        }

    }

}