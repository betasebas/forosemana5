package com.example.mascotaforo5.data.repository
import com.example.mascotaforo5.R
import com.example.mascotaforo5.data.model.CuidadoMascota
import com.example.mascotaforo5.data.model.Mascota
import com.example.mascotaforo5.data.model.Producto

class TiendaRepository {
    fun obtenerProductos(): List<Producto> {
        return listOf(
            Producto(1, "Alimento Premium Perros", "Bolsa de 10kg de alta proteína", 125000.0, R.drawable.comida_perro),
            Producto(2, "Juguete Mordedor", "Caucho resistente para cachorros", 35000.0, R.drawable.juguete),
            Producto(3, "Rascador para Gatos", "Estructura de 3 niveles con cuerda", 180000.0, R.drawable.rascador),
            Producto(4, "Arena para Gatos", "Bolsa de 5kg, control de olores", 45000.0, R.drawable.arena)
        )
    }

    fun obtenerMascotas(): List<Mascota> {
        return listOf(
            Mascota(1, "Max", "Golden Retriever", "3 meses", R.drawable.mascota_max, R.raw.video_mascota),
            Mascota(2, "Luna", "Gato Persa", "1 año", R.drawable.mascota_luna, R.raw.video_mascota),
            Mascota(3, "Rocky", "Bulldog Francés", "6 meses", R.drawable.mascota_kevin, R.raw.video_mascota)
        )
    }

    fun obtenerAudiosCuidado(): List<CuidadoMascota> {
        return listOf(
            CuidadoMascota(1, "Cuidados del cachorro", "Aprende lo básico para los primeros meses", R.raw.audio_cuidado),
            CuidadoMascota(2, "Nutrición felina", "Qué debe comer tu gato para estar sano",  R.raw.audio_cuidado),
            CuidadoMascota(3, "Entrenamiento básico", "Comandos esenciales para perros", R.raw.audio_cuidado)
        )
    }
}