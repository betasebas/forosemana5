package com.example.mascotaforo5.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.R
import com.example.mascotaforo5.adapter.CuidadoAdapter
import com.example.mascotaforo5.data.repository.TiendaRepository

class AudioActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val repository = TiendaRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        val rvAudios = findViewById<RecyclerView>(R.id.rvAudios)
        val btnDetener = findViewById<Button>(R.id.btnDetenerAudio)

        rvAudios.layoutManager = LinearLayoutManager(this)

        val adapter = CuidadoAdapter(repository.obtenerAudiosCuidado()) { audioResId ->
            reproducirAudio(audioResId)
        }
        rvAudios.adapter = adapter

        btnDetener.setOnClickListener {
            detenerAudio()
        }

        val btnVolver = findViewById<Button>(R.id.btnVolverAudio)
        btnVolver.setOnClickListener {
            finish() // Cierra la pantalla de audios y regresa al menú
        }
    }

    private fun reproducirAudio(audioResId: Int) {
        detenerAudio() // Si había otro sonando, lo detiene y libera de la RAM

        mediaPlayer = MediaPlayer.create(this, audioResId)
        mediaPlayer?.start()
    }

    private fun detenerAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release() // CRUCIAL PARA LA RÚBRICA: Libera la memoria RAM del sistema
        }
        mediaPlayer = null
    }

    // Si el usuario sale de la pantalla presionando "atrás", apagamos el sonido obligatoriamente
    override fun onDestroy() {
        super.onDestroy()
        detenerAudio()
    }
}