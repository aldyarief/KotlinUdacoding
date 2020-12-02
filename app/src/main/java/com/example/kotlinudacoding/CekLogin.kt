package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CekLogin : AppCompatActivity() {
    var eduser: EditText? = null
    var edpass: EditText? = null
    var login: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_login)

        eduser = findViewById<View>(R.id.eduser) as EditText
        edpass = findViewById<View>(R.id.edpass) as EditText
        login = findViewById<View>(R.id.btnLogin) as Button

        login!!.setOnClickListener {
            val username = eduser!!.text.toString().trim { it <= ' ' }
            val pass = edpass!!.text.toString().trim { it <= ' ' }


            if (!username.isEmpty() && !pass.isEmpty() ) {
                if (username.equals("aldry") && pass.equals("a")) {
                    Toast.makeText(this@CekLogin, "Selamat Datang $username", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@CekLogin, DashboardWeek2::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@CekLogin, "Anda tidak bisa masuk", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@CekLogin, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onBackPressed() {
        val intent = Intent(this@CekLogin,DashboardWeek2 ::class.java)
        startActivity(intent)
        finish()
    }
}