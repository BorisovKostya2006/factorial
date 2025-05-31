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
    private val _error = MutableLiveData<Boolean>()
    val error : LiveData<Boolean>
        get() {
            return _error
        }
    private val _factorial = MutableLiveData<String>()
    val factorial : LiveData<String>
        get() {
            return _factorial
        }
    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar : LiveData<Boolean>
        get() {
            return _progressBar
        }
    fun calculate(inputText: String) {
        if (inputText.isNullOrBlank()){
            _error.value = true
            return
                    }
        else{
            viewModelScope.launch {
                _progressBar.value = true
                delay(3000)
                _factorial.value = inputText.toString()
                _progressBar.value = false
            }
            }

    }

}