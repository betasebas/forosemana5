package com.example.mascotaforo5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.data.model.CuidadoMascota
import com.example.mascotaforo5.R

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