package com.example.kotlinudacoding.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.model.Daerah

class DaerahAdapter(var data: ArrayList<Daerah>?) : RecyclerView.Adapter<DaerahAdapter.DaerahHolder>() {
    class DaerahHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaerahHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DaerahHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}