package co.edu.eam.unilocal_prueba.bd

import co.edu.eam.unilocal_prueba.models.Categoria

object Categorias {

    private val categorias: ArrayList<Categoria> = ArrayList()

    init {
        categorias.add(Categoria(1, "Hotel"))
        categorias.add(Categoria(2, "Café"))
        categorias.add(Categoria(3, "Restaurante"))
        categorias.add(Categoria(4, "Parque"))
        categorias.add(Categoria(5, "Bar"))
    }

    fun listar(): ArrayList<Categoria> {
        return categorias
    }

    fun obtener(id: Int): Categoria? {
        return categorias.firstOrNull { c -> c.id == id }
    }
}