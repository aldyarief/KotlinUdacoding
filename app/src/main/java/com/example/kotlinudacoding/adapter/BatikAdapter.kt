package com.example.kotlinudacoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.Batik
import com.example.kotlinudacoding.model.HasilItem
import kotlinx.android.synthetic.main.item_batik.view.*

class BatikAdapter(var data: ArrayList<HasilItem>?) : RecyclerView.Adapter<BatikAdapter.BatikHolder>() {
    class BatikHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.itemImg
        val textName = itemView.itemNamaLokasi
        val itemNamaTempat = itemView.itemNamaTempat
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikAdapter.BatikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent,false)
        val holder = BatikAdapter.BatikHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: BatikAdapter.BatikHolder, position: Int) {
        holder.itemNamaTempat.text = data?.get(position)?.daerahBatik
        holder.textName.text = data?.get(position)?.namaBatik
        Glide.with(holder.itemView.context).load(data?.get(position)?.linkBatik).into(holder.img)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0

    }
}