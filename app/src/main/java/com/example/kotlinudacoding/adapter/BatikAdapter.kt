package com.example.kotlinudacoding.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.detail.BatikDetail
import com.example.kotlinudacoding.model.HasilItem
import kotlinx.android.synthetic.main.item_batik.view.*

class BatikAdapter(var hasil: List<HasilItem?>?
) : RecyclerView.Adapter<BatikAdapter.BatikHolder>() {


    inner class BatikHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.itemImg
        val itemMakna = itemView.itemMakna
        val itemNama = itemView.itemNama
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent,false)
        val holder = BatikHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: BatikHolder, position: Int) {
       holder.itemNama.text = hasil?.get(position)?.namaBatik
       holder.itemMakna.text = hasil?.get(position)?.maknaBatik
        Glide.with(holder.itemView.context).load(hasil?.get(position)?.linkBatik).into(holder.img)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BatikDetail::class.java)
            intent.putExtra("nama", hasil?.get(position)?.namaBatik)
            intent.putExtra("desc", hasil?.get(position)?.maknaBatik)
            intent.putExtra("img", hasil?.get(position)?.linkBatik)
            intent.putExtra("hargamin", hasil?.get(position)?.hargaRendah)
            intent.putExtra("hargamax", hasil?.get(position)?.hargaTinggi)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hasil?.size ?: 0

    }

}