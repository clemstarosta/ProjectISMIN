package com.ismin.android

/**
 * Fragment that manages the display of the list of women
 */
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val WOMEN = "women"

class WomenListFragment : Fragment() {

    private lateinit var womanAdapter: WomanAdapter
    private lateinit var rcvWomen: RecyclerView
    private var listener: ListCallBack? = null
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
        val rootView = inflater.inflate(R.layout.fragment_woman_list, container, false)

        womanAdapter = WomanAdapter(women, listener)

        rcvWomen = rootView.findViewById(R.id.f_woman_list_rcv_women)
        rcvWomen.adapter = womanAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        rcvWomen.layoutManager = linearLayoutManager

        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListCallBack) {
            listener = context
        }
        else {
            throw java.lang.RuntimeException("$context must implement Favorite")
        }
    }

    override fun onDetach(){
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance(women: ArrayList<Woman>) =
            WomenListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(WOMEN, women)
                }
            }
    }
}