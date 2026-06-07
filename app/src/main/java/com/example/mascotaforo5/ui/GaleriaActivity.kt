package com.example.mascotaforo5.ui

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotaforo5.R
import com.example.mascotaforo5.adapter.MascotaAdapter
import com.example.mascotaforo5.data.repository.TiendaRepository

/**
 * Actividad que funciona como una galería interactiva, combinando un catálogo visual con un reproductor de video.
 * * * Utiliza un [RecyclerView] configurado con [MascotaAdapter] para listar las mascotas disponibles.
 * * Implementa [ExoPlayer] para gestionar y reproducir los videos locales (desde la carpeta res/raw o res/drawable)
 * asociados a cada animal seleccionado.
 * * Maneja de forma segura el ciclo de vida del reproductor, garantizando que se libere la memoria RAM
 * mediante el método [onDestroy] cuando la pantalla se cierra.
 */
class GaleriaActivity : AppCompatActivity() {
    private lateinit var playerView: PlayerView
    private var exoPlayer: ExoPlayer? = null
    private val repository = TiendaRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)

        // 1. Enlazamos la vista
        playerView = findViewById(R.id.videoReproductor)

        // 2. Inicializamos ExoPlayer
        exoPlayer = ExoPlayer.Builder(this).build()
        playerView.player = exoPlayer

        // 3. Configuramos la lista
        val rvMascotas = findViewById<RecyclerView>(R.id.rvMascotas)
        rvMascotas.layoutManager = LinearLayoutManager(this)

        val adapter = MascotaAdapter(repository.obtenerMascotas()) { mascota ->
            reproducirVideo(mascota.videoResId)
        }
        rvMascotas.adapter = adapter

        val btnVolver = findViewById<Button>(R.id.btnVolverGaleria)
        btnVolver.setOnClickListener {
            finish() // Cierra la galería y regresa al menú
        }
    }

    private fun reproducirVideo(videoResId: Int) {
        val rutaVideo = "android.resource://" + packageName + "/" + videoResId
        val uri = Uri.parse(rutaVideo)

        // Creamos el ítem multimedia de ExoPlayer
        val mediaItem = MediaItem.fromUri(uri)

        // Lo cargamos y le damos play
        exoPlayer?.setMediaItem(mediaItem)
        exoPlayer?.prepare()
        exoPlayer?.play()
    }

    // BUENA PRÁCTICA DE MEMORIA: Liberar el reproductor al salir de la pantalla
    override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.release()
        exoPlayer = null
    }
}