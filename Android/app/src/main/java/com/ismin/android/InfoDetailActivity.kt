package com.ismin.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity that manages the details (description display) of a woman
 */

class InfoDetailActivity : AppCompatActivity(){

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

        //Recovery of the description
        desc1 = intent.getStringExtra("desc1").toString()
        desc2 = intent.getStringExtra("desc2").toString()
        desc3 = intent.getStringExtra("desc3").toString()
        desc4 = intent.getStringExtra("desc4").toString()
        desc5 = intent.getStringExtra("desc5").toString()

        //Display of the description
        findViewById<TextView>(R.id.r_woman_desc1).text = desc1
        findViewById<TextView>(R.id.r_woman_desc2).text = desc2
        findViewById<TextView>(R.id.r_woman_desc3).text = desc3
        findViewById<TextView>(R.id.r_woman_desc4).text = desc4
        findViewById<TextView>(R.id.r_woman_desc5).text = desc5

        //Back to main activity button
        Retour = findViewById(R.id.buttonRetour_detail)

        // creation of the return intent
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