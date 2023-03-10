package com.example.gifsearchapp.Utilities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import java.util.*

object Utility {


    //Hide keyboard
 fun hideKeyboard(activity: Activity) {
        val input: InputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        input.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }


    //Network connection check
    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

    //custom background for snackbar
    fun Snackbar.background(color: Int): Snackbar {
        this.view.setBackgroundColor(color)
        return this
    }

    fun View.visible(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun ImageView.loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .into(this)
    }

}