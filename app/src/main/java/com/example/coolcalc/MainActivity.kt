package com.example.coolcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val addModel = CoolCalcAdd()
    private val subModel = CoolCalcSub()
    private val multiplyModel = CoolCalcMultiply()
    private val divideModel = CoolCalcDiv()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumberText = findViewById<EditText>(R.id.first_number)
        val secondNumberText = findViewById<EditText>(R.id.second_number)
        val addButton = findViewById<Button>(R.id.add_button)
        val subButton = findViewById<Button>(R.id.sub_button)
        val multiplyButton = findViewById<Button>(R.id.multiply_button)
        val divButton = findViewById<Button>(R.id.div_button)

        addButton.setOnClickListener {
            val firstNumber = firstNumberText
                ?.text
                ?.toString()
                ?.toDouble()
                ?: 0.0
            val secondNumber = secondNumberText
                ?.text
                ?.toString()
                ?.toDouble()
                ?: 0.0

            val sum = addModel.addNumbers(firstNumber, secondNumber)
            handleAnswer(sum)
        }

        subButton.setOnClickListener {
            val firstNumber = firstNumberText
                    ?.text
                    ?.toString()
                    ?.toDouble()
                    ?: 0.0
            val secondNumber = secondNumberText
                    ?.text
                    ?.toString()
                    ?.toDouble()
                    ?: 0.0


            val difference = subModel.subNumbers(firstNumber, secondNumber)
            handleAnswer(difference)
        }
        multiplyButton.setOnClickListener {
            val firstNumber = firstNumberText
                ?.text
                ?.toString()
                ?.toDouble()
                ?: 0.0
            val secondNumber = secondNumberText
                ?.text
                ?.toString()
                ?.toDouble()
                ?: 0.0

            val product = multiplyModel.multiplyNumbers(firstNumber, secondNumber)
            handleAnswer(product)
        }
        divButton.setOnClickListener {
            val firstNumber = firstNumberText
                ?.text
                ?.toString()
                ?.toDouble()
                ?: 0.0
            val secondNumber = secondNumberText
                ?.text
                ?.toString()
                ?.toDouble()
                ?: 0.0

            val quotient = divideModel.divideNumbers(firstNumber, secondNumber)
            handleAnswer(quotient)
        }
    }

    private fun handleAnswer(answer: Double){
        val answerText = findViewById<TextView>(R.id.answer)
        val equalView = findViewById<TextView>(R.id.eqauls)
        val clearButton = findViewById<TextView>(R.id.clear_button)

        answerText.text = answer.toString()
        answerText.visibility = View.VISIBLE
        equalView.visibility = View.VISIBLE
        clearButton.visibility = View.VISIBLE
        clearButton.setOnClickListener{reset()}
    }
    private fun reset(){
        val answerText = findViewById<TextView>(R.id.answer)
        val equalView = findViewById<TextView>(R.id.eqauls)
        val clearButton = findViewById<TextView>(R.id.clear_button)
        val firstNumberText = findViewById<EditText>(R.id.first_number)
        val secondNumberText = findViewById<EditText>(R.id.second_number)
        
        answerText.visibility = View.GONE
        equalView.visibility = View.GONE
        clearButton.visibility = View.GONE
        firstNumberText.text = null
        secondNumberText.text = null
    }
}