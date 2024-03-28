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

        val numberTicket: EditText = findViewById(R.id.inputNumberTicket)
        val authButton: Button = findViewById(R.id.authButton)

        authButton.setOnClickListener {
            val ticket = numberTicket.text.toString().trim()

/*            val temp1 = "87654321".trim()
            val temp2 = "Данил".trim()
            val temp3 = "Петров".trim()
            val temp4 = "Алехандрович".trim()*/

            if (ticket == "") {
/*                val user = User(temp1, temp2, temp3, temp4)
                val db = DBHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "$temp1 $temp2 $temp3 $temp4", Toast.LENGTH_SHORT).show()*/

                Toast.makeText(this, "Введите номер билета", Toast.LENGTH_SHORT).show()
            }
            else {
                val db = DBHelper(this, null)
                val isAuth = db.getUser(ticket)
                if (isAuth) {
                    Toast.makeText(this, "Пользователь авторизован", Toast.LENGTH_SHORT).show()
                    numberTicket.text.clear()
                }
                else {
                    Toast.makeText(this, "Пользователь не существует", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}