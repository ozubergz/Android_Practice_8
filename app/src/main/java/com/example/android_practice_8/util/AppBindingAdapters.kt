package com.example.android_practice_8.util

import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


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
 * Used to trigger enter key listener action
 */
@BindingAdapter("addEnterKeyListener")
fun TextInputEditText.addEnterKeyListener(f: Function0<Unit>?) {

   if(f == null) setOnEditorActionListener(null)
    else setOnEditorActionListener { _, actionId, event ->

        // this checks which imeOption button has been pressed from UI keyboard
        val imeAction = when (actionId) {
            EditorInfo.IME_ACTION_DONE,
            EditorInfo.IME_ACTION_SEND,
            EditorInfo.IME_ACTION_GO -> true
            else -> false
        }

        // check if enter key has been pressed down
        val keyDown = event?.keyCode == KeyEvent.KEYCODE_ENTER
                && event.action == KeyEvent.ACTION_DOWN

        if(imeAction or keyDown) true.also{ f();closeKeyboard() }
        else false
    }
}


/**
 * Custom DataBinding Method
 * Used to trigger on click on button actions
 */
@BindingAdapter("addClickListener")
fun MaterialButton.addClickListener(f: Function0<Unit>?) = setOnClickListener {
    f?.invoke()
    closeKeyboard()
}

