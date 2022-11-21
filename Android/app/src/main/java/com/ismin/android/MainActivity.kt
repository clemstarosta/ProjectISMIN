package com.ismin.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), WomanCreator {

    private val womenList = WomenList()
    private val btnCreateWoman: FloatingActionButton by lazy { findViewById(R.id.a_main_btn_create_woman) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val woman = Woman("Simone Signoret", "77 Illustres Parisiennes", "15 place Dauphine", "Auteure et actrice française Simone Signoret tourne avec les plus grands.",
            "Elle est la seconde actrice française à recevoir l'oscar de la meilleure actrice en 1960, puis le César de la meilleure actrice en 1977.",
            "Populaire auprès des français, elle tiendra de nombreux rôles tout au long de sa carrière et n'hésitera pas à affirmer ses idées politiques en signant par exemple le Manifeste des 121 en 1960, déclaration sur le droit à l'insoumission dans la guerre d'Algérie.",
            "Mariée à Yves Montand ils passeront une partie de leur vie dans l'ancienne librairie à la Roulotte au 15 place Dauphine.",
            "Tous deux reposent aujourd'hui au Père-Lachaise.")
        womenList.addWoman(woman)
        val anotherWoman = Woman("Nikki de St Phalle", "Artistes", "Fontaine Stravinksy",
            "Artiste peintre, plasticienne et sculptrice franco-américaine Nikki de St Phalle est membre du groupe des Nouveaux réalistes.",
            "Elle devient mondialement connue avec ses tableaux de la collection 'Tir', série de tableaux en peinture et plâtre réalisée dans les années 60 .",
            "En 1971 elle se marie avec Jean Tinguely et réalise avec lui la Fontaine Stravinsky créée dans le cadre de la construction du Centre Pompidou.",
            "",
            "")
        womenList.addWoman(anotherWoman)

        displayWomanListFragment()

        btnCreateWoman.setOnClickListener {
            displayCreateWomanFragment()
        }
    }

    private fun displayWomanListFragment() {
        val womanListFragment = WomanListFragment.newInstance(womenList.getAllWomen())
        supportFragmentManager.beginTransaction()
            .replace(R.id.a_main_frame_layout, womanListFragment)
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
                displayWomanListFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onWomanCreated(woman: Woman) {
        womenList.addWoman(woman)
        displayWomanListFragment()
    }
}