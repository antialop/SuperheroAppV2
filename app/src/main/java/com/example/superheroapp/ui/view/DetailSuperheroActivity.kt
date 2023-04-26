package com.example.superheroapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.superheroapp.databinding.ActivityDetailSuperheroBinding
import com.example.superheroapp.ui.domain.PowerStats
import com.example.superheroapp.ui.domain.SuperHeroDetail
import com.example.superheroapp.ui.viewmodel.SuperheroDetailViewModel
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "extra_id"
    }
    private lateinit var binding:ActivityDetailSuperheroBinding
    private val superheroDetailsViewModel: SuperheroDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Recuperar id, si el valor es null vacio
        val id : String = intent.getStringExtra(EXTRA_ID).orEmpty()
        superheroDetailsViewModel.postDetails(id)

        superheroDetailsViewModel.superheroDetail.observe(this, Observer {
            createUI(it)
        })
    }



    private fun createUI(superhero: SuperHeroDetail) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        binding.tvPublisher.text = superhero.biography.publisher
    }
    private fun prepareStats(powerstats: PowerStats) {
        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewPower, powerstats.power)
    }
    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }
    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }


}