package com.example.kotlinudacoding.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.detail.CovidDetail
import com.example.kotlinudacoding.model.ListDataItem
import kotlinx.android.synthetic.main.item_covid.view.*


class CovidAdapter(var hasil: List<ListDataItem?>?
) : RecyclerView.Adapter<CovidAdapter.CovidHolder>() {

    inner class CovidHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNama = itemView.itemCovid
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid, parent,false)
        val holder = CovidHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CovidHolder, position: Int) {
        holder.itemNama.text = hasil?.get(position)?.key

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CovidDetail::class.java)
            intent.putExtra("wilayah", hasil?.get(position)?.key)
            intent.putExtra("case", hasil?.get(position)?.jumlahKasus)
            intent.putExtra("rawat", hasil?.get(position)?.jumlahDirawat)
            intent.putExtra("sembuh", hasil?.get(position)?.jumlahSembuh)
            intent.putExtra("meninggal", hasil?.get(position)?.jumlahMeninggal)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hasil?.size ?: 0
    }
}