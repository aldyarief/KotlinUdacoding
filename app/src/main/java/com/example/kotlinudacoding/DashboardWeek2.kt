package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class DashboardWeek2 : AppCompatActivity() {
    var kalkulator: LinearLayout?= null
    var umur: LinearLayout?= null
    var login: LinearLayout?= null
    var listview: LinearLayout?= null
    var recycler: LinearLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboardweek2)

        kalkulator = findViewById<View>(R.id.kalkukator) as LinearLayout
        umur = findViewById<View>(R.id.umur) as LinearLayout
        login = findViewById<View>(R.id.login) as LinearLayout
        listview = findViewById<View>(R.id.list) as LinearLayout
        recycler = findViewById<View>(R.id.recyler) as LinearLayout

        kalkulator!!.setOnClickListener {
            val intent = Intent(this@DashboardWeek2, Kalkulator::class.java)
            startActivity(intent)
            finish()
        }

        umur!!.setOnClickListener {
            val intent = Intent(this@DashboardWeek2, HitungUmur::class.java)
            startActivity(intent)
            finish()
        }

        login!!.setOnClickListener {
            val intent = Intent(this@DashboardWeek2, CekLogin::class.java)
            startActivity(intent)
            finish()
        }

        listview!!.setOnClickListener {
            val intent = Intent(this@DashboardWeek2, ImplementasiListview::class.java)
            startActivity(intent)
            finish()
        }

        recycler!!.setOnClickListener {
            val intent = Intent(this@DashboardWeek2, Recyclerview::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        val intent = Intent(this@DashboardWeek2,Dashboard ::class.java)
        finish()
        startActivity(intent)
    }
}