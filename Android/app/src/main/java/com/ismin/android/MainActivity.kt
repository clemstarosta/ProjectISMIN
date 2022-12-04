package com.ismin.android


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val SERVER_BASE_URL = "https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io"

class MainActivity : AppCompatActivity(), WomanCreator {

    private val womenList = WomenList()
    private val btnCreateWoman: FloatingActionButton by lazy { findViewById(R.id.a_main_btn_create_woman) }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(SERVER_BASE_URL)
        .build()

    private val womanService = retrofit.create(WomanService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        womanService.getAllWomen()
            .enqueue(object : Callback<List<Woman>> {
                override fun onResponse(
                    call: Call<List<Woman>>,
                    response: Response<List<Woman>>
                ) {
                    val allWomen: List<Woman>? = response.body()
                    allWomen?.forEach {womenList.addWoman(it)}
                }

                override fun onFailure(call: Call<List<Woman>>, t: Throwable) {
                    Toast.makeText(applicationContext, "It fails with error", Toast.LENGTH_SHORT).show()
                }
            })

        displayWomenListFragment()

        btnCreateWoman.setOnClickListener {
            displayCreateWomanFragment()
        }
    }

    private fun displayWomenListFragment() {
        val womenListFragment = WomenListFragment.newInstance(womenList.getAllWomen())
        supportFragmentManager.beginTransaction()
            .replace(R.id.a_main_frame_layout, womenListFragment)
            .commit()
        btnCreateWoman.show()

    }

    private fun displayCreateWomanFragment() {
        val createWomanFragment = CreateWomanFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.a_main_frame_layout, createWomanFragment)
            .commit()
        btnCreateWoman.hide()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_clean -> {
                womenList.clean()
                displayWomenListFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onWomanCreated(woman: Woman) {

        womanService.addWoman(woman)
            .enqueue(object : Callback<Woman> {
                override fun onResponse(
                    call: Call<Woman>,
                    response: Response<Woman>
                ) {
                    response.body()?.let {womenList.addWoman(it)}
                    displayWomenListFragment()
                }

                override fun onFailure(call: Call<Woman>, t: Throwable) {
                    Toast.makeText(applicationContext, "It fails with error", Toast.LENGTH_SHORT).show()
                }
            })

    }


}

