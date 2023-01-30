package com.example.gifsearchapp

import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gifsearchapp.data.DataObject
import com.example.gifsearchapp.data.DataResult
import com.example.gifsearchapp.databinding.ActivityMainBinding
import com.example.gifsearchapp.presentation.main.MainActivity
import com.example.gifsearchapp.presentation.main.MainViewModel
import net.bytebuddy.matcher.ElementMatchers.any
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.AdditionalMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

class MainActivityTests {


    val activity = MainActivity()

   private lateinit var viewModel: ViewModel

    @Before
    fun setUp() {
        viewModel = ViewModelProvider(activity).get(MainViewModel::class.java)
    }



    @Test
    fun `Test retrofitRequest`() {
//TODO
    }

    @Test
    fun `Test showSnackbar`() {

     //TODO
    }

    }