package com.example.kotlinudacoding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
                Log.d("response server", response.message())

                if (response.isSuccessful){
                    val status = response.body()?.status_code

                    if (status == 200) {

                        val data2 = response.body()?.data

                        showData(data2)

                    }
                }
            }

            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                Log.d("response server", t.message!!)
            }
        })
    }

    private fun showData(data: ArrayList<HasilItem>?) {
        listbatik.adapter = BatikAdapter(data)
    }


}