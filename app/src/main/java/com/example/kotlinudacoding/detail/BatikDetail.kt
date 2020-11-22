package com.example.kotlinudacoding.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlinudacoding.R
import kotlinx.android.synthetic.main.activity_batik_detail.*
import java.text.NumberFormat
import java.util.*

class BatikDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik_detail)

        val localeID = Locale(
            "in",
            "ID"
        )
        val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
        val nama: String? = intent.getStringExtra("nama")
        val desc: String? = intent.getStringExtra("desc")
        val img: String? = intent.getStringExtra("img")
        val min: Int? = intent.getIntExtra("hargamin", 0)
        val max: Int? = intent.getIntExtra("hargamax", 0)

        detailNama.text = nama
        deskripsi.text = desc
        Glide.with(this@BatikDetail).load(img).into(imgBatik)
        hargamin.text =  "Harga min : ${formatRupiah.format(min)}"
        hargamax.text = "Harga max : ${formatRupiah.format(max)}"

    }
}