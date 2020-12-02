package com.example.kotlinudacoding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinudacoding.adapter.MuseumAdapter
import com.example.kotlinudacoding.model.DataItem
import com.example.kotlinudacoding.model.Museum
import com.example.kotlinudacoding.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_museum_apps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MuseumApps : AppCompatActivity() {
    var server : String? = null
    var cari: EditText? = null
    var btncari: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_apps)

        server = "http://jendela.data.kemdikbud.go.id/"
        cari = findViewById<View>(R.id.cari) as EditText
        btncari = findViewById<View>(R.id.btnCari) as Button

        ConfigNetwork.getRetrofit(server!!).getDataMuseum().enqueue(object : Callback<Museum> {

            override fun onResponse(call: Call<Museum>, response: Response<Museum>) {
                Log.d("response server", response.message())

                if (response.isSuccessful) {

                    val hasil = response.body()?.data

                    showData(hasil)
                }
            }

            override fun onFailure(call: Call<Museum>, t: Throwable) {
                Log.d("response server", t.message!!)
            }
        })

        btncari!!.setOnClickListener {
            val datacari = cari!!.text.toString().trim { it <= ' ' }

            ConfigNetwork.getRetrofit(server!!).getCariMuseum(datacari).enqueue(object : Callback<Museum> {
                override fun onResponse(call: Call<Museum>, response: Response<Museum>) {
                    if (response.isSuccessful) {

                        val hasil = response.body()?.data

                        showData(hasil)
                    }
                }

                override fun onFailure(call: Call<Museum>, t: Throwable) {
                    Log.d("response server", t.message!!)
                }

            })

        }
    }

    private fun showData(hasil: List<DataItem?>?) {
        listmuseum.adapter = MuseumAdapter(hasil)

    }

    override fun onBackPressed() {
        val intent = Intent(this@MuseumApps, DashboardWeek3::class.java)
        startActivity(intent)
        finish()
    }


}