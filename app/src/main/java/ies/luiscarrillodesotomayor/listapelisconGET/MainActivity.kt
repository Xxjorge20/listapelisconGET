package ies.luiscarrillodesotomayor.listapelisconGET

import android.app.DownloadManager.Query
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ies.luiscarrillodesotomayor.listapelisconGET.PeliculasDeVerdad.PeliculasResponder
import ies.luiscarrillodesotomayor.listapelisconGET.Vista.ListaPeliculasAdapter
import ies.luiscarrillodesotomayor.listapelisconGET.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // no varia la lista de peliculas y se inicializa el recycler view
        binding.ListaPeliculas.layoutManager = LinearLayoutManager(this)
        val filmAdapter = ListaPeliculasAdapter(emptyList())
        binding.ListaPeliculas.adapter = filmAdapter




        CoroutineScope(Dispatchers.IO).launch {
            val llamada = getRetrofit().create(APIService::class.java)
                .getPopularMovies("movie/popular?api_key=95602258efaa238e976d8e7cee202e60")
            val respuestaPeli = llamada.body()

            runOnUiThread() {
                if (llamada.isSuccessful) {
                    var resultado = respuestaPeli?.results ?: emptyList()
                    filmAdapter.peliculas = resultado
                    filmAdapter.notifyDataSetChanged()
                    Toast.makeText(this@MainActivity, "Peliculas cargadas", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        }



    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
















