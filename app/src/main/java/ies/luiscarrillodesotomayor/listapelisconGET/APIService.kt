package ies.luiscarrillodesotomayor.listapelisconGET


import ies.luiscarrillodesotomayor.listapelisconGET.PeliculasDeVerdad.PeliculasResponder
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getPopularMovies(@Url url:String): Response<PeliculasResponder>

}

