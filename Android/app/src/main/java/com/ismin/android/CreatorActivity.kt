package com.ismin.android


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * CreatorActivity
 * Activity that displays the screen for creating a woman
 */

class CreatorActivity : AppCompatActivity(), WomanCreator {

    private val womenList = WomenList()
    lateinit var Retour : Button

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(SERVER_BASE_URL)
        .build()

    private val womanService = retrofit.create(WomanService::class.java)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creator)

        //Back to main activity button
        Retour = findViewById(R.id.buttonRetour)

        // creation of the return intent
        val monIntentRetour : Intent =  Intent(this,MainActivity::class.java)

        Retour.setOnClickListener {
            startActivity(monIntentRetour)
        }

        //fragment of a woman's creation
        val createWomanFragment = CreateWomanFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.a_creator_frame_layout, createWomanFragment)
            .commit()

    }

    override fun onWomanCreated(woman: Woman) {
        /**
         * onWomanCreated
         * Creation of a woman
         */

        womanService.addWoman(woman)
            .enqueue(object : Callback<Woman> {
                override fun onResponse(
                    call: Call<Woman>,
                    response: Response<Woman>
                ) {
                    response.body()?.let {womenList.addWoman(it)}
                    val createWomanFragment = CreateWomanFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.a_creator_frame_layout, createWomanFragment)
                        .commit()
                }

                override fun onFailure(call: Call<Woman>, t: Throwable) {
                    Toast.makeText(applicationContext, "It fails with error", Toast.LENGTH_SHORT).show()
                }
            })

    }

}