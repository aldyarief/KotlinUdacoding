package com.example.kotlinudacoding.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.Anggota

class ListViewAdapter (private val context: Context, private val data: List<Anggota>): BaseAdapter() {
    override fun getView(position: Int, converterView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)

        val foto = view.findViewById<ImageView>(R.id.image)
        val nama = view.findViewById<TextView>(R.id.nama)

        val item = data?.get(position)

        foto.setImageResource(item.foto)
        nama.text = item.nama
        return view
    }

    override fun getItem(position: Int): Any {
        return data?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = data.size

    }
