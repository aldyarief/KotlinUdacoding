package com.example.kotlinudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinudacoding.adapter.PengunjungAdapter
import com.example.kotlinudacoding.model.HasildataItem
import com.example.kotlinudacoding.model.Pengunjung
import com.example.kotlinudacoding.network.ConfigNetwork
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.activity_pengunjung_apps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PengunjungApps : AppCompatActivity() {
    var server : String? = null
    var action : String? = null
    var nama: EditText? = null
    var alamat: EditText? = null
    var telp: EditText? = null
    var buttonsave: MaterialCardView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengunjung_apps)

        server = "http://aldry.agustianra.my.id/"
        nama = findViewById(R.id.nama) as EditText
        alamat = findViewById(R.id.alamat) as EditText
        telp = findViewById(R.id.telp) as EditText
        buttonsave = findViewById<View>(R.id.btnSave) as MaterialCardView

        AmbilData()
        buttonsave!!.setOnClickListener {
            val namapen = nama!!.text.toString().trim { it <= ' ' }
            val alamatpen = alamat!!.text.toString().trim { it <= ' ' }
            val telppen = telp!!.text.toString().trim { it <= ' ' }
            action = "insertdata"

           // ConfigNetwork.getRetrofit(server!!).getInsertPengunjung(action!!,namapen,alamatpen,telppen).enqueue(object : Callback<Pengunjung> {
             //   override fun onResponse(call: Call<Pengunjung>, response: Response<Pengunjung>) {
               //     Log.d("response server", response.message())

                 //   if (response.isSuccessful){
                   //     Toast.makeText(this@PengunjungApps, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
                     //   AmbilData()
                    //}
                //}

                //override fun onFailure(call: Call<Pengunjung>, t: Throwable) {
                 //   Log.d("response server", t.message!!)
                //}

            //})

        }
    }

    private fun showData(datapengunjung: List<HasildataItem?>?) {
        listpengunjung.adapter = PengunjungAdapter(datapengunjung)
    }

    fun AmbilData() {
        action = "showdata"
        ConfigNetwork.getRetrofit(server!!).getDataPengunjung(action!!).enqueue(object : Callback<Pengunjung> {

            override fun onResponse(call: Call<Pengunjung>, response: Response<Pengunjung>) {
                Log.d("response server", response.message())

                if (response.isSuccessful){

                    val datapengunjung = response.body()?.hasildata

                    showData(datapengunjung)
                }
            }

            override fun onFailure(call: Call<Pengunjung>, t: Throwable) {
                Log.d("response server", t.message!!)
            }
        })

    }

    override fun onBackPressed() {
        val intent = Intent(this@PengunjungApps,Dashboard ::class.java)
        finish()
        startActivity(intent)
    }
}