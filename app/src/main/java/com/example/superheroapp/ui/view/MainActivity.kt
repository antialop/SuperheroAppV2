package com.example.superheroapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.core.RetrofitHelper.getRetrofit
import com.example.superheroapp.databinding.ActivityMainBinding
import com.example.superheroapp.ui.view.DetailSuperheroActivity.Companion.EXTRA_ID
import com.example.superheroapp.ui.viewmodel.SuperheroViewModel
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter
    private val superheroViewModel: SuperheroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUnit()
        retrofit = getRetrofit()

        superheroViewModel.superHeroDataResponse.observe(this, Observer {
            adapter.updateList(it)
        })
    }

    private fun initUnit() {

        //SEARCHVIEW
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Busca al pulsar boton
            override fun onQueryTextSubmit(query: String?): Boolean {
                superheroViewModel.searchByName(query.orEmpty())
                return false
            }

            //Busca a medida que vamos escribiendo
            override fun onQueryTextChange(newText: String?) = false
        })
        //ADAPTER
        adapter = SuperheroAdapter{ navigateToDetail(it) }

        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }


    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        Log.i("antia", id)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }


}