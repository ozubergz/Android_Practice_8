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

    /**
     * 2 way binding to observe user input; get's data from input
     */
    val query : ObservableField<String> = ObservableField("")

    fun fetchAcronym() {
        viewModelScope.launch(Dispatchers.IO) {
            /* let -> executes a block that are non-null values */
            query.get()?.let {
                acronymRepository.fetchAcronym(it)
            }
        }
    }

}