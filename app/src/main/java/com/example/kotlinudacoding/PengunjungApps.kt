package com.example.kotlinudacoding

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kotlinudacoding.adapter.OnDeleteItemClickListener
import com.example.kotlinudacoding.adapter.OnEditItemClikListener
import com.example.kotlinudacoding.adapter.PengunjungAdapter
import com.example.kotlinudacoding.model.HasildataItem
import com.example.kotlinudacoding.model.Pengunjung
import com.example.kotlinudacoding.network.ConfigNetwork
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_pengunjung.view.*
import kotlinx.android.synthetic.main.activity_pengunjung_apps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PengunjungApps : AppCompatActivity(), OnEditItemClikListener, OnDeleteItemClickListener {
    var server : String? = null
    var action : String? = null
    var nama: EditText? = null
    var alamat: EditText? = null
    var telp: EditText? = null
    var pengunjungid: TextView? = null
    var buttonsave: MaterialCardView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengunjung_apps)

        server = "http://aldry.agustianra.my.id/"
        nama = findViewById(R.id.nama) as EditText
        alamat = findViewById(R.id.alamat) as EditText
        telp = findViewById(R.id.telp) as EditText
        pengunjungid = findViewById(R.id.idpen) as TextView
        buttonsave = findViewById<View>(R.id.btnSave) as MaterialCardView


        AmbilData()
        action=""

        buttonsave!!.setOnClickListener {
            val namapen = nama!!.text.toString().trim { it <= ' ' }
            val alamatpen = alamat!!.text.toString().trim { it <= ' ' }
            val telppen = telp!!.text.toString().trim { it <= ' ' }
            val kunjungid = pengunjungid!!.text.toString().trim{ it <= ' '}

            if (action.equals("")) {
                action = "insertdata"
            }

            if (action.equals("insertdata")) {

                ConfigNetwork.getRetrofit(server!!).getInsertPengunjung(action!!,kunjungid, namapen, alamatpen, telppen).enqueue(object : Callback<Pengunjung> {
                        override fun onResponse(call: Call<Pengunjung>, response: Response<Pengunjung>) {
                            Log.d("response server", response.message())

                            if (response.isSuccessful) {
                                val hasilnya = response.body()?.pesan
                                Toast.makeText(this@PengunjungApps, hasilnya, Toast.LENGTH_SHORT).show()
                                AmbilData()
                                nama!!.getText().clear()
                                alamat!!.getText().clear()
                                telp!!.getText().clear()
                                action=""

                            }
                        }

                        override fun onFailure(call: Call<Pengunjung>, t: Throwable) {
                            Log.d("response server", t.message!!)
                        }

                    })
            }   else if (action.equals("editdata")) {
                ConfigNetwork.getRetrofit(server!!).getEditPengunjung(action!!,kunjungid, namapen, alamatpen, telppen).enqueue(object : Callback<Pengunjung> {
                    override fun onResponse(call: Call<Pengunjung>, response: Response<Pengunjung>) {
                        Log.d("response server", response.message())

                        if (response.isSuccessful) {
                            val hasilnya = response.body()?.pesan
                            Toast.makeText(this@PengunjungApps, hasilnya, Toast.LENGTH_SHORT).show()
                            AmbilData()
                            nama!!.getText().clear()
                            alamat!!.getText().clear()
                            telp!!.getText().clear()
                            pengunjungid!!.text=""
                            action=""

                        }
                    }

                    override fun onFailure(call: Call<Pengunjung>, t: Throwable) {
                        Log.d("response server", t.message!!)
                    }

                })
            }

        }
    }

    private fun showData(datapengunjung: List<HasildataItem?>?) {
        listpengunjung.adapter = PengunjungAdapter(datapengunjung,this,this)
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
        startActivity(intent)
        finish()
    }

    override fun onItemClick(item: HasildataItem?, position: Int) {
        nama?.setText(item?.nama)
        alamat?.setText(item?.alamat)
        telp?.setText(item?.telp)
        pengunjungid?.setText(item?.idpengunjung)
        action="editdata"
    }

    override fun onDelete(item: HasildataItem?, position: Int) {
        nama?.setText(item?.nama)
        alamat?.setText(item?.alamat)
        telp?.setText(item?.telp)
        pengunjungid?.setText(item?.idpengunjung)
        showDialog()
    }

    private fun showDialog(){
        lateinit var dialog: AlertDialog
        val namapen = nama!!.text.toString().trim { it <= ' ' }
        val alamatpen = alamat!!.text.toString().trim { it <= ' ' }
        val telppen = telp!!.text.toString().trim { it <= ' ' }
        val kunjungid = pengunjungid!!.text.toString().trim{ it <= ' '}
        action="deletedata"


        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pengunjung Apss")
        builder.setMessage("Yakin akan menghapus data pengunjung?")

        val dialogClickListener = DialogInterface.OnClickListener{ _, which ->
            when(which){

                DialogInterface.BUTTON_POSITIVE ->
                    ConfigNetwork.getRetrofit(server!!).getDeletePengunjung(action!!,kunjungid, namapen, alamatpen, telppen).enqueue(object : Callback<Pengunjung> {
                        override fun onResponse(call: Call<Pengunjung>, response: Response<Pengunjung>) {
                            Log.d("response server", response.message())

                            if (response.isSuccessful) {
                                val hasilnya = response.body()?.pesan
                                Toast.makeText(this@PengunjungApps, hasilnya, Toast.LENGTH_SHORT).show()
                                AmbilData()
                                nama!!.getText().clear()
                                alamat!!.getText().clear()
                                telp!!.getText().clear()
                                pengunjungid!!.text=""
                                action=""

                            }
                        }

                        override fun onFailure(call: Call<Pengunjung>, t: Throwable) {
                            Log.d("response server", t.message!!)
                        }

                    })

                DialogInterface.BUTTON_NEGATIVE -> dialog.dismiss();
            }
        }


        builder.setPositiveButton("YES",dialogClickListener)
        builder.setNegativeButton("NO",dialogClickListener)
        dialog = builder.create()
        dialog.show()
    }
}