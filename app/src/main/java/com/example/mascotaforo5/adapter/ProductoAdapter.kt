package com.example.mascotaforo5.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.R
import com.example.mascotaforo5.data.model.Producto
import com.example.mascotaforo5.ui.ProductoDetalleActivity

/**
 * Adaptador encargado de mostrar un catálogo de productos en un RecyclerView.
 * * Enlaza la información de cada [Producto] (nombre, precio e imagen) con su representación
 * visual en [R.layout.item_producto]. Además, este adaptador gestiona su propia lógica
 * de navegación: al hacer clic en un ítem, lanza directamente [ProductoDetalleActivity]
 * pasando los detalles del producto a través de un Intent.
 *
 * @property productos Lista de objetos de tipo [Producto] que se van a listar.
 */
class ProductoAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombreProducto)
        val tvPrecio: TextView = view.findViewById(R.id.tvPrecioProducto)
        val imgProducto: ImageView = view.findViewById(R.id.imgProducto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.tvNombre.text = producto.nombre
        holder.tvPrecio.text = "$${producto.precio}"
        holder.imgProducto.setImageResource(producto.imagenResId)

        // Agregamos el evento de clic a toda la "tarjeta" (itemView)
        holder.itemView.setOnClickListener {
            // Obtenemos el contexto desde la vista
            val context = holder.itemView.context

            // Preparamos el Intent para viajar a la pantalla de detalles
            val intent = Intent(context, ProductoDetalleActivity::class.java).apply {
                putExtra("EXTRA_NOMBRE", producto.nombre)
                putExtra("EXTRA_DESCRIPCION", producto.descripcion)
                putExtra("EXTRA_PRECIO", producto.precio)
                putExtra("EXTRA_IMAGEN", producto.imagenResId)
            }

            // Iniciamos la nueva actividad
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productos.size
    }
}