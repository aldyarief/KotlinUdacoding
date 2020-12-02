package com.example.kotlinudacoding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class HitungUmur : AppCompatActivity() {
    var txumur: EditText? = null
    var hitung: Button? = null
    var txView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_umur)

        txumur = findViewById<View>(R.id.txtDate) as EditText
        hitung = findViewById<View>(R.id.btnHitungUmur) as Button
        txView = findViewById<View>(R.id.txhasil) as TextView

        hitung!!.setOnClickListener {
            val tahun = txumur!!.text.toString().trim { it <= ' ' }

            if (!tahun.isEmpty()) {
                val tahunlahir = tahun.toInt()
                val tahunini = Calendar.getInstance().get(Calendar.YEAR)
                if (tahunlahir > tahunini) {
                    Toast.makeText(this@HitungUmur, "Tahun lahir tidak boleh lebih besar dari tahun saat ini.", Toast.LENGTH_SHORT).show()
                } else {
                    val hasil = tahunini - tahunlahir
                    txView!!.text = "Umur anda adalah $hasil tahun"
                }

            } else {
                Toast.makeText(this@HitungUmur, "Tahun lahir tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onBackPressed() {
        val intent = Intent(this@HitungUmur,DashboardWeek2 ::class.java)
        startActivity(intent)
        finish()
    }
}