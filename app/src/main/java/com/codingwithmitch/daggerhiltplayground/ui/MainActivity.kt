package com.codingwithmitch.daggerhiltplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingwithmitch.daggerhiltplayground.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}



















