package com.example.android_practice_8.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


/**
 * Use to set RecyclerView adapter
 */
@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    this.adapter = adapter
}