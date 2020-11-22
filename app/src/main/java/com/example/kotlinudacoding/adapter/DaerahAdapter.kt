package com.example.kotlinudacoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.Daerah
import com.example.kotlinudacoding.model.HasilItem
import com.example.kotlinudacoding.model.ProvinsiItem
import kotlinx.android.synthetic.main.item_batik.view.*
import kotlinx.android.synthetic.main.item_batik.view.itemNama
import kotlinx.android.synthetic.main.item_daerah.view.*

class DaerahAdapter(var data: List<ProvinsiItem?>?) : RecyclerView.Adapter<DaerahAdapter.DaerahHolder>() {
    class DaerahHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemDaerah = itemView.itemNama
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaerahHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daerah, parent,false)
        val holder = DaerahHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: DaerahHolder, position: Int) {
        holder.itemDaerah.text = data?.get(position)?.nama
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}