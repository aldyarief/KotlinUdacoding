package com.example.kotlinudacoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinudacoding.adapter.BatikAdapter
import com.example.kotlinudacoding.adapter.CovidAdapter
import com.example.kotlinudacoding.model.Batik
import com.example.kotlinudacoding.model.Covid
import com.example.kotlinudacoding.model.ListDataItem
import com.example.kotlinudacoding.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batikapps.*
import kotlinx.android.synthetic.main.activity_covid_apps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidApps : AppCompatActivity() {
    var server : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_apps)

        server = "http://data.covid19.go.id/public/"

        ConfigNetwork.getRetrofit(server!!).getDataCovid().enqueue(object : Callback<Covid> {

            override fun onResponse(call: Call<Covid>, response: Response<Covid>) {
                Log.d("response server", response.message())

                if (response.isSuccessful){

                    val hasil = response.body()?.listData

                    showData(hasil)
                }
            }

            override fun onFailure(call: Call<Covid>, t: Throwable) {
                Log.d("response server", t.message!!)
            }
        })
    }

    private fun showData(hasil: List<ListDataItem?>?) {
        listcovid.adapter = CovidAdapter(hasil)
    }


}