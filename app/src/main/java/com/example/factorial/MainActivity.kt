package com.example.factorial

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText = findViewById<EditText>(R.id.editTextNumber)
        val calculateFactorialButton = findViewById<Button>(R.id.CalculateFactorialButton)
        val textView = findViewById<TextView>(R.id.textView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        calculateFactorialButton.setOnClickListener {
            if (inputText.text.isNullOrBlank()){
                Toast.makeText(this,"Input number", Toast.LENGTH_SHORT).show()
            }else{
                lifecycleScope.launch {
                    progressBar.visibility = View.VISIBLE
                    delay(3000)
                    textView.text = inputText.text
                    progressBar.visibility = View.GONE
                }
            }


        }
    }
}