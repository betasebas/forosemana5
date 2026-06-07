package com.example.mascotaforo5.ui

import androidx.lifecycle.ViewModel
import com.example.mascotaforo5.data.model.Producto
import com.example.mascotaforo5.data.repository.TiendaRepository

/**
 * ViewModel encargado de gestionar y preparar los datos de la tienda para la interfaz de usuario.
 * * Actúa como puente o intermediario entre la vista (Activity/Fragment) y la capa de datos ([TiendaRepository]).
 * * Al heredar de [ViewModel], garantiza que la información (como [listaProductos]) sobreviva
 * a cambios de configuración, como la rotación del dispositivo, sin tener que volver a consultar los datos.
 */
class TiendaViewModel : ViewModel() {
    // Instanciamos el repositorio que creaste
    private val repository = TiendaRepository()

    // Obtenemos los datos para que la vista (Activity/Fragment) los pueda leer
    val listaProductos: List<Producto> = repository.obtenerProductos()
}