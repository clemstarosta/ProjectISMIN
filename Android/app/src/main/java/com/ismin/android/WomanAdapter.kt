package com.ismin.android

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class WomanAdapter(private var women: List<Woman>) : RecyclerView.Adapter<WomanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WomanViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(
            R.layout.row_woman, parent,
            false
        )
        return WomanViewHolder(row)
    }

    override fun onBindViewHolder(holder: WomanViewHolder, position: Int) {
        val woman = women[position];
        holder.name.text = woman.name
        holder.desc1.text = woman.desc1
        holder.desc2.text = woman.desc2
        holder.desc3.text = woman.desc3
        holder.desc4.text = woman.desc4
        holder.desc5.text = woman.desc5
        holder.place.text = woman.place
        holder.category.text = woman.category

        val img: ImageView = holder.image
        Picasso.get()
            .load(woman.thumb_url)
            .into(img)

    }

    override fun getItemCount(): Int {
        return women.size
    }

    fun refreshData(allWomen: List<Woman>) {
        this.women = allWomen;
    }
}