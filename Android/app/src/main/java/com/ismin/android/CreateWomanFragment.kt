package com.ismin.android

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

/**
 * CreateWomanFragment
 * Management of the woman's creation fragment
 */

class CreateWomanFragment : Fragment() {

    private var listener: WomanCreator? = null
    lateinit var edtName: EditText
    lateinit var edtCategory: EditText
    lateinit var edtPlace: EditText
    lateinit var edtDesc1: EditText
    lateinit var edtDesc2: EditText
    lateinit var edtDesc3: EditText
    lateinit var edtDesc4: EditText
    lateinit var edtDesc5: EditText
    lateinit var edtLat: EditText
    lateinit var edtLong: EditText
    lateinit var edtURL: EditText
    lateinit var btnSave: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_create_woman, container, false)

        edtName = rootView.findViewById(R.id.f_create_woman_edt_name)
        edtCategory = rootView.findViewById(R.id.f_create_woman_edt_category)
        edtPlace = rootView.findViewById(R.id.f_create_woman_edt_place)
        edtDesc1 = rootView.findViewById(R.id.f_create_woman_edt_desc1)
        edtDesc2 = rootView.findViewById(R.id.f_create_woman_edt_desc2)
        edtDesc3 = rootView.findViewById(R.id.f_create_woman_edt_desc3)
        edtDesc4 = rootView.findViewById(R.id.f_create_woman_edt_desc4)
        edtDesc5 = rootView.findViewById(R.id.f_create_woman_edt_desc5)
        edtLat = rootView.findViewById(R.id.f_create_woman_edt_lat)
        edtLong = rootView.findViewById(R.id.f_create_woman_edt_long)
        edtURL = rootView.findViewById(R.id.f_create_woman_edt_url)

        btnSave = rootView.findViewById(R.id.f_create_woman_btn_save)

        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            val desc1 = edtDesc1.text.toString()
            val desc2 = edtDesc2.text.toString()
            val desc3 = edtDesc3.text.toString()
            val desc4 = edtDesc4.text.toString()
            val desc5 = edtDesc5.text.toString()
            val place = edtPlace.text.toString()
            val category = edtCategory.text.toString()
            val long = edtLong.text.toString().toInt()
            val lat = edtLat.text.toString().toInt()
            val url = edtURL.text.toString()

            val woman = Woman(name, desc1,desc2,desc3,desc4,desc5,place,category, long, lat, url,false)
            listener?.onWomanCreated(woman)
        }

        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is WomanCreator) {
            listener = context
        } else {
            throw RuntimeException("$context must implement WomanCreator")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateWomanFragment()
    }
}