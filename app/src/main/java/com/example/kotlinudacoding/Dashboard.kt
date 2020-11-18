package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class Dashboard : AppCompatActivity() {
    var week2: LinearLayout?= null
    var week3: LinearLayout?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        week2 = findViewById<View>(R.id.week2) as LinearLayout
        week3 = findViewById<View>(R.id.week3) as LinearLayout


        week2!!.setOnClickListener {
            val intent = Intent(this@Dashboard, DashboardWeek2::class.java)
            finish()
            startActivity(intent)
        }

        week3!!.setOnClickListener {
            val intent = Intent(this@Dashboard, BatikApps::class.java)
            finish()
            startActivity(intent)
        }
    }

}