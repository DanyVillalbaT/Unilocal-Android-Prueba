package co.edu.eam.unilocal_prueba.bd

import co.edu.eam.unilocal_prueba.models.Usuario

object Usuarios {

    private val usuarios: ArrayList<Usuario> = ArrayList()

    init {
        usuarios.add(Usuario(1, "Daniela", "dany", "daniela@email.com", "123"))
        usuarios.add(Usuario(2, "Angie", "angie", "angie@email.com", "456"))
        usuarios.add(Usuario(3, "Alejandro", "alejo", "alejandro@email.com", "789"))
        usuarios.add(Usuario(4, "Marcos", "marcos", "marcos@email.com", "147"))
        usuarios.add(Usuario(5, "Maria", "maria", "maria@email.com", "258"))
    }

    fun listar(): ArrayList<Usuario> {
        return usuarios
    }

    fun agregar(usuario: Usuario){
        //Hay que validar que no se repita el correo y la contraseña
        usuarios.add(usuario)
    }

    fun login(correo: String, password: String): Usuario {
        val usuario = usuarios.first { u -> u.correo == correo && u.password == password }
        return usuario
    }
}