package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class DashboardWeek3 : AppCompatActivity() {

    var batik: LinearLayout?= null
    var museum: LinearLayout?= null
    var daerah: LinearLayout?= null
    var covid: LinearLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_week3)

        batik = findViewById<View>(R.id.batik) as LinearLayout
        museum = findViewById<View>(R.id.museum) as LinearLayout
        daerah = findViewById<View>(R.id.daerah) as LinearLayout
        covid = findViewById<View>(R.id.covid) as LinearLayout

        batik!!.setOnClickListener {
            val intent = Intent(this@DashboardWeek3, BatikApps::class.java)
            finish()
            startActivity(intent)
        }
    }
}