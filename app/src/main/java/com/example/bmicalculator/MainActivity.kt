package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight:EditText = findViewById(R.id.etWeigh)
        val etHeight:EditText = findViewById(R.id.etHeight)

        val button:Button = findViewById(R.id.testButton)
        val bmiTextView: TextView = findViewById(R.id.tvYourBmi)
        val imageView: ImageView = findViewById(R.id.ivBmi)

        button.setOnClickListener{
            val bmi = calculateBMI(
                etWeight.text.toString().toDouble(),
                etHeight.text.toString().toDouble()
            )
            bmiTextView.text = bmi.toString()
            if (bmi > 25){
                imageView.setImageResource(R.drawable.ic_running)
            }else{
                imageView.setImageResource(R.drawable.ic_food)
            }
        }

    }

    fun calculateBMI(height:Double, weight: Double) : Double {
        return weight / (height/100).pow(2)
    }
}