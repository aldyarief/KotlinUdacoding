package com.example.kotlinudacoding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.Anggota

class RecyclerViewAdapter (
    private val context : Context,
    private val data : List<Anggota>,
    private val itemClick : onClickListener
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }
    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.foto.setImageResource(item.foto)
        holder.nama.text = item.nama

        holder.view.setOnClickListener {
            itemClick.detailData(item)
        }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val foto = view.findViewById<ImageView>(R.id.image)
        val nama = view.findViewById<TextView>(R.id.nama)
    }


    interface onClickListener{
        fun detailData(item : Anggota?)
    }
}