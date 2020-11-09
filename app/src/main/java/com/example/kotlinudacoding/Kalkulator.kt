package com.example.kotlinudacoding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Kalkulator : AppCompatActivity() {
    var hasil: Double? = null
    var txtinggi: EditText? = null
    var txberat: EditText? = null
    var button: Button? = null
    var txView: TextView? = null
    var statusBadan : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)
        txberat = findViewById<View>(R.id.edberat) as EditText
        txtinggi = findViewById<View>(R.id.edtinggi) as EditText
        button = findViewById<View>(R.id.btnHitung) as Button
        txView = findViewById<View>(R.id.txhasil) as TextView


        button!!.setOnClickListener {
            val berat = txberat!!.text.toString().trim { it <= ' ' }
            val tinggi = txtinggi!!.text.toString().trim { it <= ' ' }

            if (!berat.isEmpty() && !tinggi.isEmpty()) {
                hasil = berat.toDouble() / (tinggi.toDouble() * tinggi.toDouble())

                if(hasil!!<18.5){
                    statusBadan = "Anda kekurangan berat badan.";
                } else if(hasil!!>=18.5 && hasil!!<=24.9){
                    statusBadan = "Berat badan anda normal (ideal).";
                } else if(hasil!!>=25 && hasil!!<=29.9){
                    statusBadan = "Anda kelebihan berat badan.";
                } else {
                    statusBadan = "Anda kegemukan (obesitas).";
                }
                txView!!.text = statusBadan

            } else if (tinggi.isEmpty()) {
                Toast.makeText(
                    this@Kalkulator,
                    "Tinggi badan tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (berat.isEmpty()) {
                Toast.makeText(
                    this@Kalkulator,
                    "Berat badan tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }
    }
    override fun onBackPressed() {
        val intent = Intent(this@Kalkulator,Dashboard ::class.java)
        finish()
        startActivity(intent)
    }

}