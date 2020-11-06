package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class Dashboard : AppCompatActivity() {
    var kalkulator: LinearLayout?= null
    var umur: LinearLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        kalkulator = findViewById<View>(R.id.kalkukator) as LinearLayout
        umur = findViewById<View>(R.id.umur) as LinearLayout

        kalkulator!!.setOnClickListener {
            val intent = Intent(this@Dashboard, Kalkulator::class.java)
            finish()
            startActivity(intent)
        }

    }
}