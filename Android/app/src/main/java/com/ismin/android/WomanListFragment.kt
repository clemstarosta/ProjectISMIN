package com.ismin.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val WOMEN = "women"

class WomanListFragment : Fragment() {
    private lateinit var womanAdapter: WomanAdapter
    private lateinit var rcvWomen: RecyclerView
    private var women: ArrayList<Woman> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            women = it.getSerializable(WOMEN) as ArrayList<Woman>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_woman_list, container, false)

        womanAdapter = WomanAdapter(women)

        rcvWomen = rootView.findViewById(R.id.f_woman_list_rcv_women)
        rcvWomen.adapter =  womanAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        rcvWomen.layoutManager = linearLayoutManager

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(women: ArrayList<Woman>) =
            WomanListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(WOMEN, women)
                }
            }
    }
}