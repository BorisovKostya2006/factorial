package com.example.factorial

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger

class ViewModelActivity : ViewModel() {
    private val _state = MutableLiveData<State>()
    val state : LiveData<State>
        get() = _state
    fun calculate(inputText: String) {
        if (inputText.isNullOrBlank()){
            _state.value = isError()
            return
                    }
        else{
            val number = inputText.toLong()
            viewModelScope.launch {
                _state.value = isProgressBar()
                _state.value = isFactorial(factorial(number))
            }
            }

    }
    suspend fun factorial(number : Long) : String{
        return withContext(Dispatchers.Default){
            var result = BigInteger.ONE
            for (i in 1 .. number){
                result = result.multiply(BigInteger.valueOf(i))
            }
            result.toString()
        }

    }

}