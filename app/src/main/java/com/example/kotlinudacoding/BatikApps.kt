package com.example.kotlinudacoding

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.adapter.BatikAdapter
import com.example.kotlinudacoding.model.Batik
import com.example.kotlinudacoding.model.ResponseServer
import com.example.kotlinudacoding.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batikapps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BatikApps : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: BatikAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batikapps)

        recyclerView = findViewById<View>(R.id.listbatik) as RecyclerView

        adapter = BatikAdapter(ArrayList<Batik>())

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@BatikApps)

        recyclerView!!.setLayoutManager(layoutManager)

        recyclerView!!.setAdapter(adapter)

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

    private fun showdata(data: ArrayList<Batik>) {
        listbatik.adapter = BatikAdapter(data)
    }

}