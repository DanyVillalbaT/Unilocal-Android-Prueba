package co.edu.eam.unilocal_prueba.models

class Categoria (var id: Int, var nombre: String, var icono: String) {

    override fun toString(): String {
        return "Categoria(id=$id, nombre='$nombre', icono='$icono')"
    }
}