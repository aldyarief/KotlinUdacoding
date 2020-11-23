package com.example.kotlinudacoding.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinudacoding.R
import kotlinx.android.synthetic.main.activity_covid_detail.*
import kotlinx.android.synthetic.main.activity_museum_detail.*

class MuseumDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_detail)


        val wilayah: String? = intent.getStringExtra("wilayah")
        val nama: String? = intent.getStringExtra("nama")
        val berdiri: String? = intent.getStringExtra("berdiri")
        val pengelola: String? = intent.getStringExtra("pengelola")
        val alamat: String? = intent.getStringExtra("alamat")

        detailLetak.text = "Provinsi : ${(wilayah)}"
        detailMuseum.text = nama
        detailBerdiri.text = "Tahun Berdiri : ${(berdiri)}"
        detailPengelola.text =  "Dikelola oleh : ${(pengelola)}"
        detailAlamat.text = "Alamat : ${(alamat)}"
    }
}