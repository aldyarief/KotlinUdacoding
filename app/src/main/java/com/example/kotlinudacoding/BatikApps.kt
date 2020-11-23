package com.example.kotlinudacoding

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlinudacoding.adapter.BatikAdapter
import com.example.kotlinudacoding.model.Batik
import com.example.kotlinudacoding.model.HasilItem
import com.example.kotlinudacoding.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batikapps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BatikApps : AppCompatActivity() {
    var server : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batikapps)
        server = "http://batikita.herokuapp.com/index.php/"

        ConfigNetwork.getRetrofit(server!!).getDataBatik().enqueue(object : Callback<Batik> {

            override fun onResponse(call: Call<Batik>, response: Response<Batik>) {
                Log.d("response server", response.message())

                if (response.isSuccessful){

                    val hasil = response.body()?.hasil

                    showData(hasil)
                }
            }

            override fun onFailure(call: Call<Batik>, t: Throwable) {
                Log.d("response server", t.message!!)
            }
        })
    }

    private fun showData(hasil: List<HasilItem?>?) {
        listbatik.adapter = BatikAdapter(hasil)
    }
    override fun onBackPressed() {
        val intent = Intent(this@BatikApps,DashboardWeek3 ::class.java)
        finish()
        startActivity(intent)
    }

}