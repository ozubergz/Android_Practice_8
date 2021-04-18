package com.example.android_practice_8.viewmodel

import android.util.Log
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

    private val _meanings = MutableLiveData<List<Lf>>()
    val meanings : LiveData<List<Lf>> get() = _meanings

    /**
     * 2 way binding to observe user input; get's data from input
     */
    val query : ObservableField<String> = ObservableField("")


    /**
     * Callback function used to listen to trigger actions
     * Button
     * TextInputEditText
     */
    val fetch : Function0<Unit> = this::fetchAcronym

    private fun fetchAcronym() {
        viewModelScope.launch(Dispatchers.IO) {
            /* let -> executes a block of that are non-null values */
            query.get()?.let {
                _meanings.postValue(acronymRepository.fetchAcronym(it))
            }
        }
    }

}