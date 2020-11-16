package com.example.kotlinudacoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinudacoding.adapter.BatikAdapter
import com.example.kotlinudacoding.model.HasilItem
import com.example.kotlinudacoding.model.ResponseServer
import com.example.kotlinudacoding.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batikapps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BatikApps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batikapps)


        ConfigNetwork.getRetrofit().getDataBatik().enqueue(object : Callback<ResponseServer> {
            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                val data = response.body()?.data
                showdata(data!!)
            }

            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                Log.d("response server", t.message!!)
            }
        })
    }

    private fun showdata(data: ArrayList<HasilItem>) {
        listbatik.adapter = BatikAdapter(data)

    }

}