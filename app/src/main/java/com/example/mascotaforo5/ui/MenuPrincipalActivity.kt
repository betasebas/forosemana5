package com.example.mascotaforo5.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mascotaforo5.ui.main.MainActivity
import com.example.mascotaforo5.R

/**
 * Actividad principal que funciona como el menú de inicio y centro de navegación de la aplicación.
 * * Contiene los accesos directos a las diferentes secciones del proyecto:
 * - Catálogo de productos ([MainActivity]).
 * - Galería de mascotas con video ([GaleriaActivity]).
 * - Sección de recomendaciones en audio ([AudioActivity]).
 * * * Utiliza [Intent] explícitos para gestionar el enrutamiento y lanzar las nuevas pantallas
 * según la selección del usuario.
 */
class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val btnCatalogo = findViewById<Button>(R.id.btnIrCatalogo)
        val btnGaleria = findViewById<Button>(R.id.btnIrGaleria)
        val btnAudios = findViewById<Button>(R.id.btnIrAudios)

        // Configuración de Intents para navegar entre pantallas
        btnCatalogo.setOnClickListener {
            // MainActivity contiene tu lista de productos
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnGaleria.setOnClickListener {
            val intent = Intent(this, GaleriaActivity::class.java)
            startActivity(intent)
        }

        btnAudios.setOnClickListener {
            val intent = Intent(this, AudioActivity::class.java)
            startActivity(intent)
        }
    }
}