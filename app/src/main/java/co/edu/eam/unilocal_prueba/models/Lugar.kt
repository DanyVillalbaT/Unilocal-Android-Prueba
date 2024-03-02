package co.edu.eam.unilocal_prueba.models

import java.time.LocalDateTime

class Lugar(var ide: Int,
            var nombre: String,
            var descripcion: String,
            var imagenes: List<String>,
            var idCreador: Int,
            var estado: Boolean,
            var idCategoria: Int,
            var latitud: Float,
            var longitud: Float,
            var idCiudad: Int,
            var fecha: LocalDateTime
) {

    var telefonos: List<String> = ArrayList()
}