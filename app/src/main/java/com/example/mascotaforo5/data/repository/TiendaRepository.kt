package com.example.mascotaforo5.data.repository
import com.example.mascotaforo5.R
import com.example.mascotaforo5.data.model.CuidadoMascota
import com.example.mascotaforo5.data.model.Mascota
import com.example.mascotaforo5.data.model.Producto

/**
 * Repositorio central que actúa como la fuente de datos (Single Source of Truth) de la aplicación.
 * * * Se encarga de proveer la información necesaria para las distintas secciones de la tienda, aislando
 * la lógica de creación y obtención de datos del resto de la arquitectura (ViewModels y Activities).
 * * En esta iteración, suministra listas estáticas (mock data) simulando el comportamiento de
 * una base de datos local o una consulta a un servidor externo.
 */
class TiendaRepository {

    /** Obtiene una lista de productos relacionados con mascotas*/
    fun obtenerProductos(): List<Producto> {
        return listOf(
            Producto(1, "Alimento Premium Perros", "Bolsa de 10kg de alta proteína", 125000.0, R.drawable.comida_perro),
            Producto(2, "Juguete Mordedor", "Caucho resistente para cachorros", 35000.0, R.drawable.juguete),
            Producto(3, "Rascador para Gatos", "Estructura de 3 niveles con cuerda", 180000.0, R.drawable.rascador),
            Producto(4, "Arena para Gatos", "Bolsa de 5kg, control de olores", 45000.0, R.drawable.arena)
        )
    }

    /** Obtiene una lista de mascotas con imagenes y su respectivo video*/
    fun obtenerMascotas(): List<Mascota> {
        return listOf(
            Mascota(1, "Max", "Golden Retriever", "3 meses", R.drawable.mascota_max, R.raw.golden_video),
            Mascota(2, "Luna", "Gato Persa", "1 año", R.drawable.mascota_luna, R.raw.persa_video),
            Mascota(3, "Rocky", "Bulldog Francés", "6 meses", R.drawable.mascota_kevin, R.raw.bulldog_video)
        )
    }
    /** Obtiene una lista de mascotas  y su respectivo audio de cuidados, Por tiempo se uso el mismo audio para todsas*/
    fun obtenerAudiosCuidado(): List<CuidadoMascota> {
        return listOf(
            CuidadoMascota(1, "Cuidados del cachorro", "Aprende lo básico para los primeros meses", R.raw.audio_cuidado),
            CuidadoMascota(2, "Nutrición felina", "Qué debe comer tu gato para estar sano",  R.raw.audio_cuidado),
            CuidadoMascota(3, "Entrenamiento básico", "Comandos esenciales para perros", R.raw.audio_cuidado)
        )
    }
}