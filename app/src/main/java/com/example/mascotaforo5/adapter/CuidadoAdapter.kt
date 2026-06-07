package com.example.mascotaforo5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.data.model.CuidadoMascota
import com.example.mascotaforo5.R

/**
 * Adaptador para gestionar y mostrar la lista de cuidados de mascotas en un RecyclerView.
 * * Se encarga de inflar el diseño visual ([R.layout.item_audio]) y enlazar los datos
 * de cada cuidado (título y descripción). También maneja la interacción del usuario,
 * delegando el evento de clic para reproducir el audio correspondiente.
 *
 * @property cuidados Lista de datos de tipo [CuidadoMascota] que se van a mostrar.
 * @property onAudioClick Función lambda (callback) que se dispara cuando el usuario toca
 * un elemento de la lista. Retorna el ID del recurso de audio (`audioResId`).
 */
class CuidadoAdapter(
    private val cuidados: List<CuidadoMascota>,
    private val onAudioClick: (Int) -> Unit
) : RecyclerView.Adapter<CuidadoAdapter.CuidadoViewHolder>() {

    class CuidadoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTituloAudio)
        val tvDesc: TextView = view.findViewById(R.id.tvDescAudio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuidadoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio, parent, false)
        return CuidadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CuidadoViewHolder, position: Int) {
        val cuidado = cuidados[position]
        holder.tvTitulo.text = cuidado.titulo
        holder.tvDesc.text = cuidado.descripcion

        holder.itemView.setOnClickListener {
            onAudioClick(cuidado.audioResId)
        }
    }

    override fun getItemCount() = cuidados.size
}