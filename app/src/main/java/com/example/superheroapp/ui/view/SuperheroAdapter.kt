package com.example.superheroapp.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.ui.domain.SuperheroItem

//EL adaptador recibe un callBack, las id estan dentro del viewholder, variable que llame a un codigo y le pase un String
//El metodo navigateToResult es como si estuviero dentro de la variable onItenSelected
//Llamar a onItemSelected es commo se llamaras a navigateToResult
class SuperheroAdapter(
    private var superheroList: List<SuperheroItem> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroList: List<SuperheroItem>) {
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperheroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun getItemCount() = superheroList.size

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        //Ademas de pasar el objeto superheroe le pasamos el onItemSelected
        // y modificamos la funcion bind (viewHolder) pasandole la lambda onselectedIntem
        viewholder.bind(superheroList[position],onItemSelected)
    }
}