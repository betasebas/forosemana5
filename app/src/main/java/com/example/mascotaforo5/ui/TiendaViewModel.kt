package com.example.mascotaforo5.ui

import androidx.lifecycle.ViewModel
import com.example.mascotaforo5.data.model.Producto
import com.example.mascotaforo5.data.repository.TiendaRepository

class TiendaViewModel : ViewModel() {
    // Instanciamos el repositorio que creaste
    private val repository = TiendaRepository()

    // Obtenemos los datos para que la vista (Activity/Fragment) los pueda leer
    val listaProductos: List<Producto> = repository.obtenerProductos()
}