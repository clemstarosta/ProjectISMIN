package com.ismin.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfoDetailActivity : AppCompatActivity(){

    //Declaration de mon bouton
    lateinit var Retour : Button
    private lateinit var desc1 : String
    private lateinit var desc2 : String
    private lateinit var desc3 : String
    private lateinit var desc4 : String
    private lateinit var desc5 : String


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_detail)

        desc1 = intent.getStringExtra("desc1").toString()
        desc2 = intent.getStringExtra("desc2").toString()
        desc3 = intent.getStringExtra("desc3").toString()
        desc4 = intent.getStringExtra("desc4").toString()
        desc5 = intent.getStringExtra("desc5").toString()

        findViewById<TextView>(R.id.r_woman_desc1).text = desc1
        findViewById<TextView>(R.id.r_woman_desc2).text = desc2
        findViewById<TextView>(R.id.r_woman_desc3).text = desc3
        findViewById<TextView>(R.id.r_woman_desc4).text = desc4
        findViewById<TextView>(R.id.r_woman_desc5).text = desc5

        //Bouton de retour à l'activité principale
        Retour = findViewById(R.id.buttonRetour_detail)

        // creation de l'intent de retour
        val monIntentRetour : Intent =  Intent(this,MainActivity::class.java)

        Retour.setOnClickListener {
            startActivity(monIntentRetour)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_info_detail, menu)
        return true
    }

}