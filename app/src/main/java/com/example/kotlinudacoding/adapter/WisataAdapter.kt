package com.example.kotlinudacoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.Wisata
import kotlinx.android.synthetic.main.item_batik.view.*

class WisataAdapter(var data: ArrayList<Wisata>?) : RecyclerView.Adapter<WisataAdapter.WisataHolder>() {
    class WisataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img = itemView.itemImg
        val textName = itemView.itemMakna
        val itemNamaTempat = itemView.itemNama


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent,false)
        val holder = WisataHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: WisataHolder, position: Int) {
        holder.itemNamaTempat.text = data?.get(position)?.nama_tempat
        holder.textName.text = data?.get(position)?.lokasi
        Glide.with(holder.itemView.context).load(data?.get(position)?.gambar).into(holder.img)

        
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}


