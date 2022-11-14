package ies.luiscarrillodesotomayor.listapelisconGET.Vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ies.luiscarrillodesotomayor.listapelisconGET.PeliculasDeVerdad.Result
import ies.luiscarrillodesotomayor.listapelisconGET.R

class ListaPeliculasAdapter(var peliculas: List<Result>) : RecyclerView.Adapter<ListaPeliculasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaPeliculasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return ListaPeliculasViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaPeliculasViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.bind(pelicula)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }
}
