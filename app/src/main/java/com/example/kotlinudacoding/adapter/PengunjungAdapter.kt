package com.example.kotlinudacoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.HasildataItem
import kotlinx.android.synthetic.main.item_pengunjung.view.*


class PengunjungAdapter(var data: List<HasildataItem?>?) : RecyclerView.Adapter<PengunjungAdapter.PengunjungHolder>() {
    class PengunjungHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNama = itemView.itemNama
        val itemAlamat = itemView.itemAlamat
        val itemTelp = itemView.itemTelp
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengunjungHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pengunjung, parent,false)
        val holder = PengunjungAdapter.PengunjungHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: PengunjungHolder, position: Int) {
        holder.itemNama.text = data?.get(position)?.nama
        holder.itemAlamat.text = data?.get(position)?.alamat
        holder.itemTelp.text = data?.get(position)?.telp
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}