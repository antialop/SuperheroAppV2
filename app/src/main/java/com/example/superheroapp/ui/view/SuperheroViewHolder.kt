package com.example.superheroapp.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.ui.domain.SuperheroItem
import com.example.superheroapp.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    //Cada bind es uno de los items
    //fun bind(superheroItemResponse: SuperheroItem, onItemSelected: (String) -> Unit) {
    fun bind(
        superheroItemResponse: SuperheroItem,
        onItemSelected: (String) -> Unit,
        addFavoriteSuperhero: (SuperheroItem) -> Unit,
        removeFavoriteSuperhero: (String) -> Unit
    ) {

        binding.tvSuperheroName.text = superheroItemResponse.name
        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)

        binding.root.setOnClickListener {
            //Cada vez que se pulse la lista le pasamos el id
           onItemSelected(superheroItemResponse.superheroId)
        }
        binding.favoriteStar.setOnClickListener {
            if (!superheroItemResponse.esFavorito) {
                binding.favoriteStar.setImageResource(R.drawable.favorite_heart)
                addFavoriteSuperhero(superheroItemResponse)
                superheroItemResponse.esFavorito = !superheroItemResponse.esFavorito
            } else {
                binding.favoriteStar.setImageResource(R.drawable.non_favorite_heart)
                removeFavoriteSuperhero(superheroItemResponse.superheroId)
                superheroItemResponse.esFavorito = !superheroItemResponse.esFavorito
            }
        }
    }
}