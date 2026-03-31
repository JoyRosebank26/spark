package com.example.socialsparkapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Adjust for system bars (status bar, navigation bars) // AI ASSIST
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Connect UI components with Kotlin // AI ASSIST
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val sparkSocialize = findViewById<Button>(R.id.sparkSocialize)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Spark Socialize Button // AI ASSIST
        sparkSocialize.setOnClickListener {
            val input = timeInput.text.toString().trim()
            val validOptions = listOf("Morning", "Afternoon", "Evening")

            if (input in validOptions) {
                // Success case
                val message = when (input) {
                    "Morning" -> "Success! Send Good morning/ Would you like to grab coffee?"
                    "Afternoon" -> "Success! Send Good Afternoon/ Want to go out for lunch?"
                    "Evening" -> "Success! Send Good Evening/ Would you like to hang out?"
                    else -> ""
                }
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            } else {
                // Error case: show Toast
                Toast.makeText(
                    this,
                    "Wrong time input! Please enter Morning, Afternoon, or Evening.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Handle Reset button click
        resetButton.setOnClickListener {
            timeInput.text.clear()
            Toast.makeText(this, "Input cleared", Toast.LENGTH_SHORT).show()
        }
    }
}
