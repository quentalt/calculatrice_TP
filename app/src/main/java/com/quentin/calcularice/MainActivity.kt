package com.quentin.calcularice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextC: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        editTextC = findViewById(R.id.editTextC)
        resultTextView = findViewById(R.id.resultTextView)

        val addButton: Button = findViewById(R.id.addButton)
        val subtractButton: Button = findViewById(R.id.subtractButton)
        val divideButton: Button = findViewById(R.id.divideButton)
        val multiplyButton: Button = findViewById(R.id.multiplyButton)

        addButton.setOnClickListener {
            calculate('+')
        }

        subtractButton.setOnClickListener {
            calculate('-')
        }

        divideButton.setOnClickListener {
            calculate('/')
        }

        multiplyButton.setOnClickListener {
            calculate('*')
        }
    }

    private fun calculate(operator: Char) {
        val a = editTextA.text.toString().toDouble()
        val b = editTextB.text.toString().toDouble()
        val c = editTextC.text.toString().toDouble()

        val result = when (operator) {
            '+' -> a + b + c
            '-' -> a - b - c
            '/' -> a / b / c
            '*' -> a * b * c
            else -> throw IllegalArgumentException("Operator not supported")
        }

        resultTextView.text = "Résultat: $result"
    }
}