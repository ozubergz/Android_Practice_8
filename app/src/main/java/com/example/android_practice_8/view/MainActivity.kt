package com.example.android_practice_8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.android_practice_8.R
import com.example.android_practice_8.databinding.ActivityMainBinding
import com.example.android_practice_8.viewmodel.AcronymViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val acronymViewModel : AcronymViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDataBinding()
    }

    private fun setupDataBinding() {
        DataBindingUtil.setContentView<ActivityMainBinding>(
                this, R.layout.activity_main
        ).apply {
            lifecycleOwner = this@MainActivity
            viewModel = acronymViewModel
        }
    }
}