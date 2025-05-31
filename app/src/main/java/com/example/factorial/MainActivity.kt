package com.example.factorial

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.factorial.databinding.ActivityMainBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[ViewModelActivity::class.java]
    }
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
        binding.CalculateFactorialButton.setOnClickListener {
            viewModel.calculate(binding.editTextNumber.text.toString())
            }


        }
    private fun observeViewModel(){
        viewModel.state.observe(this){
            binding.progressBar.visibility = View.GONE
            when(it){
                is isError -> Toast.makeText(this,"Input number", Toast.LENGTH_SHORT).show()
                is isFactorial -> binding.textView.text = it.text
                is isProgressBar -> binding.progressBar.visibility = View.VISIBLE
            }
        }
    }
    }
