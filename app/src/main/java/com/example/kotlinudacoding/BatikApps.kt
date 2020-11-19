package com.example.kotlinudacoding

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
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
        listbatik.adapter = BatikAdapter(hasil, object: BatikAdapter.onClickListener{
            override fun detailData(item: HasilItem?) {
                Dialog (this@BatikApps).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    getWindow()?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                    setCancelable(true)
                    setContentView(R.layout.detail_batik)

                    val nama = this.findViewById<TextView>(R.id.detailNama)
                    val deskripsi = this.findViewById<TextView>(R.id.deskripsi)
                    val close = this.findViewById<Button>(R.id.Close)

                    nama.text = "Nama : ${item?.namaBatik}"
                    deskripsi.text = "Alamat : ${item?.maknaBatik}"

                    close.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }


}