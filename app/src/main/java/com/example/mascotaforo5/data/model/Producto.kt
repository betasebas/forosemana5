package com.example.mascotaforo5.data.model

/** Modelo que representa un Producto*/
data class Producto (
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val imagenResId: Int
)