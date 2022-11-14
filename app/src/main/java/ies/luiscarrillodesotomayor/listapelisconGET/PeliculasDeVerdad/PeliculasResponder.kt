package ies.luiscarrillodesotomayor.listapelisconGET.PeliculasDeVerdad

data class PeliculasResponder(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)