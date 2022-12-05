package com.ismin.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ismin.android.R


/**
 * Fragment that displays information about the map.
 */
class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView : View = inflater.inflate(R.layout.fragment_map, container, false)
        return rootView
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            MapFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}