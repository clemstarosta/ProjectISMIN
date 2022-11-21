package com.ismin.android

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class WomanViewHolder(rootView: View): ViewHolder(rootView) {
    var name = rootView.findViewById<TextView>(R.id.r_woman_txv_name)
    var category = rootView.findViewById<TextView>(R.id.r_woman_txv_category)
    var place = rootView.findViewById<TextView>(R.id.r_woman_txv_place)
    var desc1 = rootView.findViewById<TextView>(R.id.r_woman_txv_desc1)
    var desc2 = rootView.findViewById<TextView>(R.id.r_woman_txv_desc2)
    var desc3 = rootView.findViewById<TextView>(R.id.r_woman_txv_desc3)
    var desc4 = rootView.findViewById<TextView>(R.id.r_woman_txv_desc4)
    var desc5 = rootView.findViewById<TextView>(R.id.r_woman_txv_desc5)
}