package com.example.mascotaforo5.ui.main

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.R
import com.example.mascotaforo5.adapter.ProductoAdapter
import com.example.mascotaforo5.ui.TiendaViewModel

/**
 * Actividad que representa la pantalla del Catálogo de Productos.
 * * Se encarga de inicializar la interfaz de usuario y configurar el [RecyclerView]
 * para mostrar la lista de artículos disponibles.
 * * Utiliza [TiendaViewModel] para solicitar los datos, separando así la lógica de la
 * interfaz visual y protegiendo la información ante cambios de configuración (como la rotación).
 * * Implementa un mecanismo de navegación simple para regresar al menú principal mediante [finish].
 */
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: TiendaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos el ViewModel
        viewModel = ViewModelProvider(this).get(TiendaViewModel::class.java)

        // Configuramos el RecyclerView
        val rvProductos = findViewById<RecyclerView>(R.id.rvProductos)
        rvProductos.layoutManager = LinearLayoutManager(this)

        // Le pasamos la lista de productos del ViewModel al Adaptador
        val adapter = ProductoAdapter(viewModel.listaProductos)
        rvProductos.adapter = adapter

        val btnVolver = findViewById<Button>(R.id.btnVolverCatalogo)
        btnVolver.setOnClickListener {
            finish() // Esto te regresa al Menú Principal
        }
    }
}