package com.example.kotlinudacoding

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.kotlinudacoding.adapter.ListViewAdapter
import com.example.kotlinudacoding.model.Anggota
import kotlinx.android.synthetic.main.activity_implementasilistview.*

class ImplementasiListview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasilistview)

        val listAnggota = ArrayList<Anggota>()
        listAnggota.add(Anggota("Supri","Jl.Kenangan","0811111",R.drawable.apel))
        listAnggota.add(Anggota("Jaenudin","Jl.Buntu","08222222",R.drawable.jeruk))
        listAnggota.add(Anggota("Saiful","Jl.Disana","083333333",R.drawable.strawberry))

        val adapter = ListViewAdapter(this,listAnggota)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            Dialog (this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_list_item)

                val nama = this.findViewById<TextView>(R.id.nama)
                val alamat = this.findViewById<TextView>(R.id.alamat)
                val telepon = this.findViewById<TextView>(R.id.telepon)
                val close = this.findViewById<Button>(R.id.Close)

                val item = listAnggota.get(position)

                nama.text = "Nama : ${item.nama}"
                alamat.text = "Alamat : ${item.alamat}"
                telepon.text = "Telepon : ${item.telepon}"

                close.setOnClickListener {
                    this.dismiss()
                }
            }.show()
        }

    }
}