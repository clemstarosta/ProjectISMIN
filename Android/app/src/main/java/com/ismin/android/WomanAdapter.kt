package com.ismin.android

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

/**
 * Adapter which manages the main display
 */

class WomanAdapter(private var women: List<Woman>,private var listener: ListCallBack?) : RecyclerView.Adapter<WomanViewHolder>() {

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
        holder.place.text = woman.place
        holder.category.text = woman.category

        //Display of the woman's photo
        val img: ImageView = holder.image
        Picasso.get()
            .load(woman.thumb_url)
            .into(img)

        //Favorite button management
        holder.favori.setOnClickListener {
            woman.fav = !woman.fav
            setFavorite(holder, woman)
        }


        holder.more.setOnClickListener {
            listener?.onMoreDetail(woman)
        }

    }

    private fun setFavorite(holder: WomanViewHolder, woman: Woman) {
        if (woman.fav) {
            holder.favori.setImageResource(R.drawable.fav_on_24)
        } else {
            holder.favori.setImageResource(R.drawable.fav_off_24)
        }
    }



    override fun getItemCount(): Int {
        return women.size
    }
}