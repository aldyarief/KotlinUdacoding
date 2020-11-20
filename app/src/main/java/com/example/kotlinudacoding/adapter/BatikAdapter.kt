package com.example.kotlinudacoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.HasilItem
import kotlinx.android.synthetic.main.item_batik.view.*

class BatikAdapter(var hasil: List<HasilItem?>?,
                   private val itemClick : onClickListener
) : RecyclerView.Adapter<BatikAdapter.BatikHolder>() {


    inner class BatikHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.itemImg
        val itemDaerah = itemView.itemMakna
        val itemNama = itemView.itemNama
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent,false)
        val holder = BatikHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: BatikHolder, position: Int) {
       holder.itemNama.text = hasil?.get(position)?.namaBatik
       holder.itemDaerah.text = hasil?.get(position)?.maknaBatik
        Glide.with(holder.itemView.context).load(hasil?.get(position)?.linkBatik).into(holder.img)

        val item = hasil?.get(position)

        holder.itemView.setOnClickListener {
            itemClick.detailData(item)
        }

    }

    override fun getItemCount(): Int {
        return hasil?.size ?: 0

    }

    interface onClickListener {
        fun detailData(item: HasilItem?)
    }
}