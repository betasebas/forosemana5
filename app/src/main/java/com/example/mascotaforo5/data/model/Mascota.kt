package com.example.mascotaforo5.data.model

/** Modelo que representa una mascota*/
data class Mascota(
    val id: Int,
    val nombre: String,
    val raza: String,
    val edad: String,
    val imagenResId: Int,
    val videoResId: Int
)