package com.ismin.android
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewMenuAdapter(fragmentActivity: FragmentActivity, private var womenList: ArrayList<Woman>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DetailFragment.newInstance()
            1 -> WomenListFragment.newInstance(womenList)
            else -> {MapFragment.newInstance()}
        }
    }

}