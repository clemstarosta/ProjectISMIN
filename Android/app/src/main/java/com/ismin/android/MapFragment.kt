package com.ismin.android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val WOMEN = "women"

/**
 * Map management fragment
 */
class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var women: ArrayList<Woman> = arrayListOf()
    private var markers = ArrayList<LatLng>()

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
        var rootView : View = inflater.inflate(R.layout.fragment_map, container, false)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val supportMapFragment : SupportMapFragment = getChildFragmentManager().findFragmentById(R.id.map) as SupportMapFragment
        supportMapFragment.getMapAsync(this)
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(women: ArrayList<Woman>) =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(WOMEN, women)
                }
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        for(woman in women){

            // Add a marker on the map
            val marker = LatLng(woman.lat.toDouble(), woman.long.toDouble())
            mMap.addMarker(MarkerOptions().position(marker).title(woman.name))
            markers.add(marker)

        }
        // Move the camera on the first marker
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(markers[0]))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom (markers[0], 12.0F))

    }
}