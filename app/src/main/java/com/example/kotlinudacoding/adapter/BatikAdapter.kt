package com.example.kotlinudacoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.Batik
import kotlinx.android.synthetic.main.item_batik.view.*

class BatikAdapter(var data: ArrayList<Batik>) : RecyclerView.Adapter<BatikAdapter.BatikHolder>() {
    class BatikHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img = itemView.gambar
        val nama = itemView.namabatik
        val daerah = itemView.daerahbatik


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent,false)

        val holder = BatikHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: BatikHolder, position: Int) {
        holder.nama.text = data.get(position)?.hasil.toString()
        //holder.daerah.text = data.get(position)?.daerahBatik
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}


