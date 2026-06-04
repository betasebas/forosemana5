package com.example.mascotaforo5

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.adapter.ProductoAdapter
import com.example.mascotaforo5.ui.TiendaViewModel

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