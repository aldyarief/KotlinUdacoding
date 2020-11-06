package com.example.kotlinudacoding

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
            val tahunlahir = txumur!!.text.toString().toInt()
            val tahunini = Calendar.getInstance().get(Calendar.YEAR)

            val hasil = tahunini - tahunlahir

            txView!!.text = hasil!!.toString()
        }

    }
}