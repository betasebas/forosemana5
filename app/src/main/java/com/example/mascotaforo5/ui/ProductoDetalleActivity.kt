package com.example.mascotaforo5.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mascotaforo5.R

class ProductoDetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_detalle)

        // 1. Capturamos las vistas
        val imgProducto = findViewById<ImageView>(R.id.imgDetalleProducto)
        val tvNombre = findViewById<TextView>(R.id.tvDetalleNombre)
        val tvPrecio = findViewById<TextView>(R.id.tvDetallePrecio)
        val tvDescripcion = findViewById<TextView>(R.id.tvDetalleDescripcion)

        // 2. Recibimos los datos enviados desde la lista
        val nombre = intent.getStringExtra("EXTRA_NOMBRE")
        val descripcion = intent.getStringExtra("EXTRA_DESCRIPCION")
        val precio = intent.getDoubleExtra("EXTRA_PRECIO", 0.0)
        val imagenResId = intent.getIntExtra("EXTRA_IMAGEN", 0)

        // 3. Asignamos los datos a las vistas
        tvNombre.text = nombre
        tvDescripcion.text = descripcion
        tvPrecio.text = "$$precio"
        if (imagenResId != 0) {
            imgProducto.setImageResource(imagenResId)
        }

        val btnVolver = findViewById<Button>(R.id.btnVolverDetalle)
        btnVolver.setOnClickListener {
            finish() // Esto destruye la pantalla actual y te regresa al catálogo
        }
    }
}