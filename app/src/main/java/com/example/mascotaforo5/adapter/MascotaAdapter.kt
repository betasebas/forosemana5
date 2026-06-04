package com.example.mascotaforo5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.data.model.Mascota
import com.example.mascotaforo5.R

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