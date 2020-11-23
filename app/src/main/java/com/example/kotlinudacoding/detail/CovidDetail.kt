package com.example.kotlinudacoding.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kotlinudacoding.R
import kotlinx.android.synthetic.main.activity_batik_detail.*
import kotlinx.android.synthetic.main.activity_covid_detail.*

class CovidDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_detail)

        val wilayah: String? = intent.getStringExtra("wilayah")
        val case: Int? = intent.getIntExtra("case", 0)
        val rawat: Int? = intent.getIntExtra("rawat", 0)
        val sembuh: Int? = intent.getIntExtra("sembuh", 0)
        val meninggal: Int? = intent.getIntExtra("meninggal", 0)

        detailCovid.text = wilayah
        detailKasus.text = "Total Kasus : ${(case)}"
        detailRawat.text = "Total Dirawat : ${(rawat)}"
        detailMeninggal.text =  "Total Meninggal : ${(meninggal)}"
        detailSembuh.text = "Total Sembuh : ${(sembuh)}"
    }
}