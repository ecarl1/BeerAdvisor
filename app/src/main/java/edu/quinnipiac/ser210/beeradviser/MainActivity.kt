package edu.quinnipiac.ser210.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener{
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem
            val beerList = getBeers(color.toString())
            val beers = beerList.reduce{ str, item -> str + '\n' + item}
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers

        }
    }

    fun getBeers(color: String): List<String>{
        return when (color){
            "light" -> listOf("Jail Pale Ale", "Lager lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout stout", "Dark Daniel")
        }
    }
}