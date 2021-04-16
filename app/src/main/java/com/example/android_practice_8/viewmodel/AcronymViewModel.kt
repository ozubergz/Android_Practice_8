package com.example.android_practice_8.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_practice_8.model.Lf
import com.example.android_practice_8.repositories.AcronymRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcronymViewModel @Inject constructor(
    private val acronymRepository: AcronymRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text : LiveData<String> get() = _text

    /**
     * 2 way binding to observe user input
     */
    val query : ObservableField<String> = ObservableField("")

    fun setText() {
        _text.value = query.get()
    }

//    private val _meanings = MutableLiveData<List<Lf>>()
//    val meanings : LiveData<List<Lf>> get() = _meanings
//
//    fun fetchAcronym(query : String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            acronymRepository.fetchAcronym(query)
//        }
//    }

}