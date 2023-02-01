package com.example.gifsearchapp.presentation.main


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gifsearchapp.R
import com.example.gifsearchapp.Utilities.Utility
import com.example.gifsearchapp.Utilities.Utility.background
import com.example.gifsearchapp.data.*
import com.example.gifsearchapp.data.Links.Companion.API_KEY
import com.example.gifsearchapp.data.Links.Companion.BASE_URL
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
    lateinit var giphyAdapter: GiphyListAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (!Utility.isNetworkAvailable(this)) showSnackbar("Internet unavailable")
        else {
            setupTextWatcher(binding)
        }
    }


    fun setupTextWatcher(binding: ActivityMainBinding,) {
        val inputGiphy = binding.giphySearchInput
        inputGiphy.addTextChangedListener(
            object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                private var timer = Timer()
                private val DELAY: Long = 1500 // Milliseconds

                override fun afterTextChanged(s: Editable) {
                    timer.cancel()
                    timer = Timer()
                    timer.schedule(
                        object : TimerTask() {
                            override fun run() {
                                if(validateInput(inputGiphy.text.toString()) ){
                                    runOnUiThread {
                                        setupViewModel(inputGiphy.text.toString())
                                        Utility.hideKeyboard(this@MainActivity)
                                        setupList()
                                        setupView()
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


    @SuppressLint("UseRequireInsteadOfGet")
    fun showSnackbar(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .background(ContextCompat.getColor(this!!, R.color.red))
            .show()
    }

    private fun setupViewModel(request_text:String) {
        val factory = MainViewModelFactory(DataService(), request_text)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private fun setupList() {
        giphyAdapter = GiphyListAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = giphyAdapter.withLoadStateHeaderAndFooter(
                header = GiphyLoadStateAdapter { giphyAdapter.retry() },
                footer = GiphyLoadStateAdapter { giphyAdapter.retry() }
            )
            setHasFixedSize(true)
        }
    }

    private fun setupView() {

        lifecycleScope.launch {
            viewModel.passengers.collectLatest { pagedData ->
                giphyAdapter.submitData(pagedData)
            }
        }
    }

    fun validateInput(name: String): Boolean {
        var result = true
        if (name.isBlank()) {
            result = false
        }
        return result
    }

}