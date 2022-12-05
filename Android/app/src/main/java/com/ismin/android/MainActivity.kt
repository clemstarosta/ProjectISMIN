package com.ismin.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val SERVER_BASE_URL = "https://app-e57a2b06-3f06-4d00-842d-a8400fbbf516.cleverapps.io"

class MainActivity : AppCompatActivity(), WomanCreator {

    private val womenList = WomenList()
    private val btnCreateWoman: FloatingActionButton by lazy { findViewById(R.id.a_main_btn_create_woman) }

    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager2 : ViewPager2
    private lateinit var myViewPagerAdapter : ViewMenuAdapter


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
                    allWomen?.forEach { womenList.addWoman(it) }
                    //displayWomenListFragment()
                    displayFragments()
                }

                override fun onFailure(call: Call<List<Woman>>, t: Throwable) {
                    Toast.makeText(applicationContext, "It fails with error", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        //displayWomenListFragment()

        val monIntent : Intent =  Intent(this,CreatorActivity::class.java)

        btnCreateWoman.setOnClickListener {
            startActivity(monIntent)
            //displayCreateWomanFragment()

        }
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
                //displayFragments()
                true
            }
            else -> super.onOptionsItemSelected(item)
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



    fun displayFragments(position : Int = 1){
        tabLayout = findViewById(R.id.tab_layout)
        viewPager2 = findViewById(R.id.view_pager2)

        myViewPagerAdapter = ViewMenuAdapter(this, womenList.getAllWomen())
        viewPager2.adapter = myViewPagerAdapter

        viewPager2.currentItem = position
        tabLayout.selectTab(tabLayout.getTabAt(position))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager2.isUserInputEnabled = tab!!.position != 2
                viewPager2.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewPager2.isUserInputEnabled = position != 2
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }





}

