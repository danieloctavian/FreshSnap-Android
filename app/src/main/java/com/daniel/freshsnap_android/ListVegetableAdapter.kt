package com.daniel.freshsnap_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ListVegetableAdapter (private val listVegetable: ArrayList<Vegetables>) : RecyclerView.Adapter<ListVegetableAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhotoVegetable: ImageView = itemView.findViewById(R.id.vegetables_image)
        var tvNameVegetable: TextView = itemView.findViewById(R.id.vegetables_name_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.vegetable_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name_vegetable, photo_vegetable) = listVegetable[position]
        holder.imgPhotoVegetable.setImageResource(photo_vegetable)
        holder.tvNameVegetable.text = name_vegetable
    }

    override fun getItemCount(): Int = listVegetable.size
}