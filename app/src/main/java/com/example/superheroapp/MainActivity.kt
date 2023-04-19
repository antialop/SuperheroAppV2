package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.superheroapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun initUnit(){

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            //Busca al pulsar boton
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }
            //Busca a medida que vamos escribiendo
            override fun onQueryTextChange(newText: String?): Boolean {
            return false
            }
        })
    }
    private fun searchByName(query: String){

    }
}