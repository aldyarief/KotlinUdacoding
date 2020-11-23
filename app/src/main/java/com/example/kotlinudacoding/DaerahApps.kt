package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinudacoding.adapter.DaerahAdapter
import com.example.kotlinudacoding.model.Daerah
import com.example.kotlinudacoding.model.ProvinsiItem
import com.example.kotlinudacoding.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_daerah_apps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaerahApps : AppCompatActivity() {
    var server : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daerah_apps)

        server = "http://dev.farizdotid.com/"


        ConfigNetwork.getRetrofit(server!!).getDataDaerah().enqueue(object : Callback<Daerah> {

            override fun onResponse(call: Call<Daerah>, response: Response<Daerah>) {
                Log.d("response server", response.message())

                if (response.isSuccessful){

                    val provinsi = response.body()?.provinsi

                    showData(provinsi)
                }
            }

            override fun onFailure(call: Call<Daerah>, t: Throwable) {
                Log.d("response server", t.message!!)
            }
        })
    }

    private fun showData(provinsi: List<ProvinsiItem?>?) {
        listdaerah.adapter = DaerahAdapter(provinsi)

    }

    override fun onBackPressed() {
        val intent = Intent(this@DaerahApps,DashboardWeek3 ::class.java)
        finish()
        startActivity(intent)
    }
}