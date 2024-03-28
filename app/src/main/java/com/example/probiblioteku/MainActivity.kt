package com.example.probiblioteku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val authTextView = findViewById<TextView>(R.id.authTextView)
        val numberTicket: EditText = findViewById(R.id.inputNumberTicket)
        val authButton: Button = findViewById(R.id.authButton)

        authButton.setOnClickListener {
            var text = numberTicket.text.toString().trim();
            if (text == "") {
                Toast.makeText(this, "Введите номер билета", Toast.LENGTH_SHORT).show()
            }
            else {
                authTextView.text = text
            }
        }
    }
}