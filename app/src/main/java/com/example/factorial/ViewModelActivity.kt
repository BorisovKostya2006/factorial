package com.example.factorial

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModelActivity : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state : LiveData<State>
        get() = _state
    fun calculate(inputText: String) {
        if (inputText.isNullOrBlank()){
            _state.value = State(isError = true)
            return
                    }
        else{
            val number = inputText.toLong()
            viewModelScope.launch {
                _state.value = State(isProgressBar = true)
                delay(3000)
                _state.value = State(isProgressBar = false,isFactorial = number.toString())
            }
            }

    }

}