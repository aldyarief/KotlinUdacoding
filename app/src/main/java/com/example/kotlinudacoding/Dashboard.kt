package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class Dashboard : AppCompatActivity() {
    var week2: LinearLayout?= null
    var week3: LinearLayout?= null
    var week4: LinearLayout?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        week2 = findViewById<View>(R.id.week2) as LinearLayout
        week3 = findViewById<View>(R.id.week3) as LinearLayout
        week4 = findViewById<View>(R.id.week4) as LinearLayout


        week2!!.setOnClickListener {
            val intent = Intent(this@Dashboard, DashboardWeek2::class.java)
            startActivity(intent)
            finish()
        }

        week3!!.setOnClickListener {
            val intent = Intent(this@Dashboard, DashboardWeek3::class.java)
            startActivity(intent)
            finish()
        }

        week4!!.setOnClickListener {
            val intent = Intent(this@Dashboard, PengunjungApps::class.java)
            startActivity(intent)
            finish()
        }
    }

}