package com.example.kotlinudacoding.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.detail.CovidDetail
import com.example.kotlinudacoding.detail.MuseumDetail
import com.example.kotlinudacoding.model.DataItem
import kotlinx.android.synthetic.main.item_covid.view.*
import kotlinx.android.synthetic.main.item_museum.view.*

class MuseumAdapter(var hasil: List<DataItem?>?
) : RecyclerView.Adapter<MuseumAdapter.MuseumHolder>() {

    inner class MuseumHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNama = itemView.itemMuseum
        val itemKota = itemView.itemKota
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_museum, parent,false)
        val holder = MuseumHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: MuseumHolder, position: Int) {
        holder.itemNama.text = hasil?.get(position)?.nama
        holder.itemKota.text = hasil?.get(position)?.kabupatenKota

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MuseumDetail::class.java)
            intent.putExtra("wilayah", hasil?.get(position)?.propinsi)
            intent.putExtra("nama", hasil?.get(position)?.nama)
            intent.putExtra("berdiri", hasil?.get(position)?.tahunBerdiri)
            intent.putExtra("pengelola", hasil?.get(position)?.pengelola)
            intent.putExtra("alamat", hasil?.get(position)?.alamatJalan)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hasil?.size ?: 0
    }
}