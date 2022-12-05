package com.ismin.android

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class WomanViewHolder(rootView: View): ViewHolder(rootView) {
    var name = rootView.findViewById<TextView>(R.id.r_woman_txv_name)
    var place = rootView.findViewById<TextView>(R.id.r_woman_txv_place)
    var category = rootView.findViewById<TextView>(R.id.r_woman_txv_category)
    var image = rootView.findViewById<ImageView>(R.id.r_woman_txv_image)
    var favori = rootView.findViewById<ImageView>(R.id.r_women_fav)
    var more = rootView.findViewById<ImageView>(R.id.r_women_button)
}