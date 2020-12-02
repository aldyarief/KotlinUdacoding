package com.example.kotlinudacoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinudacoding.R
import com.example.kotlinudacoding.model.HasildataItem
import kotlinx.android.synthetic.main.item_pengunjung.view.*


class PengunjungAdapter(var data: List<HasildataItem?>?,
                        private val itemClick : OnEditItemClikListener,
                        private val deleteClick : OnDeleteItemClickListener) : RecyclerView.Adapter<PengunjungAdapter.PengunjungHolder>() {
    class PengunjungHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNama = itemView.itemNama
        val itemAlamat = itemView.itemAlamat
        val itemTelp = itemView.itemTelp
        val menuedit = itemView.menuedit
        val menudelete = itemView.menudelete

        fun initialize(item : HasildataItem?, action: OnEditItemClikListener) {
            itemNama.text = item?.nama
            itemAlamat.text = item?.alamat
            itemTelp.text = item?.telp


            menuedit.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }
        }

        fun initialize(item: HasildataItem?, action: OnDeleteItemClickListener) {
            menudelete.setOnClickListener{
                action.onDelete(item,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengunjungHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pengunjung, parent,false)
        val holder = PengunjungHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: PengunjungHolder, position: Int) {
        holder.itemNama.text = data?.get(position)?.nama
        holder.itemAlamat.text = data?.get(position)?.alamat
        holder.itemTelp.text = data?.get(position)?.telp
        holder.initialize(data?.get(position),itemClick)
        holder.initialize(data?.get(position),deleteClick)

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }


}

interface OnDeleteItemClickListener {
    fun onDelete(item: HasildataItem?, position: Int)
}

interface OnEditItemClikListener {
    fun onItemClick(item: HasildataItem?, position: Int)
}





