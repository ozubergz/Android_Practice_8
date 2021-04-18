package com.example.android_practice_8.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton


/**
 * Custom DataBinding Method
 * Used to set RecyclerView adapter
 */
@BindingAdapter("setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    this.adapter = adapter
}

/**
 * Custom DataBinding Method
 * Used to  on button actions
 */
@BindingAdapter("addOnEventListener")
fun MaterialButton.addOnEventListener(f: Function0<Unit>?) = setOnClickListener {
    f?.invoke()
    closeKeyboard()
}

