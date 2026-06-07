package com.example.mascotaforo5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.data.model.Mascota
import com.example.mascotaforo5.R

/**
 * Adaptador encargado de gestionar y mostrar el catálogo o lista de mascotas en un RecyclerView.
 * * Se encarga de enlazar la información de cada animal (imagen, nombre, raza y edad combinadas)
 * con el diseño visual de [R.layout.item_mascota].
 *
 * @property mascotas Lista de objetos de tipo [Mascota] que se representarán en la pantalla.
 * @property onMascotaClick Función lambda (callback) que se dispara cuando el usuario toca
 * la tarjeta de una mascota. Retorna el objeto [Mascota] completo, ideal para navegar a
 * una pantalla de detalles.
 */
class MascotaAdapter(
    private val mascotas: List<Mascota>,
    private val onMascotaClick: (Mascota) -> Unit
) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    class MascotaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMascota: ImageView = view.findViewById(R.id.imgMascota)
        val tvNombre: TextView = view.findViewById(R.id.tvNombreMascota)
        val tvRaza: TextView = view.findViewById(R.id.tvRazaMascota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mascota, parent, false)
        return MascotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.tvNombre.text = mascota.nombre
        holder.tvRaza.text = "${mascota.raza} - ${mascota.edad}"
        holder.imgMascota.setImageResource(mascota.imagenResId)

        // Escuchamos el clic y lo enviamos hacia afuera
        holder.itemView.setOnClickListener {
            onMascotaClick(mascota)
        }
    }

    override fun getItemCount() = mascotas.size
}