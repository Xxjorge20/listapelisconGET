package ies.luiscarrillodesotomayor.listapelisconGET.Vista

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ies.luiscarrillodesotomayor.listapelisconGET.databinding.ItemFilmBinding
import ies.luiscarrillodesotomayor.listapelisconGET.PeliculasDeVerdad.Result


class ListaPeliculasViewHolder(view: View) : RecyclerView.ViewHolder(view)
{

    val binding = ItemFilmBinding.bind(view)
    fun bind(pelicula: Result) {

        binding.FilmName.text = pelicula.title

        Glide.with(binding.FilmPhoto.context).load("https://image.tmdb.org/t/p/w185${pelicula.poster_path}").into(binding.FilmPhoto)
    }

}



