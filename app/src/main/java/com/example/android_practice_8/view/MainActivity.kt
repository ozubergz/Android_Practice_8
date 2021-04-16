package com.example.android_practice_8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.android_practice_8.R
import com.example.android_practice_8.adapter.AcronymAdapter
import com.example.android_practice_8.databinding.ActivityMainBinding
import com.example.android_practice_8.viewmodel.AcronymViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val acronymAdapter : AcronymAdapter by lazy { AcronymAdapter() }
    private val acronymViewModel : AcronymViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDataBinding()

        acronymViewModel.meanings.observe(this) {
            acronymAdapter.loadData(it)
        }
    }

    private fun setupDataBinding() {
        DataBindingUtil.setContentView<ActivityMainBinding>(
                this, R.layout.activity_main
        ).apply {
            lifecycleOwner = this@MainActivity
            viewModel = acronymViewModel
            adapter = acronymAdapter
        }
    }


}