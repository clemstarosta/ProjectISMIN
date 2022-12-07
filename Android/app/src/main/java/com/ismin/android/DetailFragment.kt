package com.ismin.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismin.android.R

/**
 * Fragment that displays the details and info of the application
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView : View = inflater.inflate(R.layout.fragment_detail, container, false)
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DetailFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}