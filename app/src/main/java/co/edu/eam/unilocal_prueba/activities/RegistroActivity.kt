package co.edu.eam.unilocal_prueba.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import co.edu.eam.unilocal_prueba.R
import co.edu.eam.unilocal_prueba.bd.Usuarios
import co.edu.eam.unilocal_prueba.databinding.ActivityRegistroBinding
import co.edu.eam.unilocal_prueba.models.Usuario
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {

    //Lo comentado es de las clases 8 y 9 PDFs y el video.
    //Lo comentado de los botones y sus métodos es de la clase 11

    lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
        binding.btnToggle.setOnClickListener {escucharEventoToggle()}

        binding.btnSwitch.setOnClickListener {escucharEventoSwitch()}

        binding.btnImage.setOnClickListener {escucharEventoImagen()}

        binding.btnFlotante.setOnClickListener {escucharEventoFlotante()}

        binding.btnFlotanteTexto.setOnClickListener {escucharEventoFlotanteTexto()}
        **/

        //Log.e("RegistroActivity", "onCreate()")

        binding.btnRegistro.setOnClickListener { registrarUsuario() }
    }

    fun registrarUsuario(){

        val nombre = binding.nombreUsuario.text.toString()
        val nickname = binding.nicknameUsuario.text.toString()
        val email = binding.emailUsuario.text.toString()
        val password = binding.passwordUsuario.text.toString()

        if (nombre.isEmpty()){
            binding.nombreLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.nombreLayout.error = null
        }

        if (nickname.isEmpty()){
            binding.nicknameLayout.error = getString(R.string.es_obligatorio)
        }else{

            if (nickname.length > 10){
                binding.nicknameLayout.error = getString(R.string.maximo_caracteres)
            }else{
                binding.nicknameLayout.error = null
            }
        }

        if (email.isEmpty()){
            binding.emailLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.emailLayout.error = null
        }

        if (password.isEmpty()){
            binding.passwordLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.passwordLayout.error = null
        }

        if (nombre.isNotEmpty() && nickname.isNotEmpty() && nickname.length <= 10 && email.isNotEmpty() && password.isNotEmpty()){
            val usuario = Usuario(4, nombre, nickname, email, password)
            Usuarios.agregar(usuario)
            Toast.makeText(this, getString(R.string.usuario_creado), Toast.LENGTH_LONG).show()
            Log.e("RegistroActivity", Usuarios.listar().toString())
        }
    }

    /**
    fun mostrarMensaje(raiz:View, mensaje:String){
        Snackbar.make(this, raiz, mensaje, Snackbar.LENGTH_LONG).show()
    }


    fun escucharEventoToggle(){
        if(binding.btnToggle.isChecked){
            mostrarMensaje(binding.btnToggle, "Botón activo")
        }else{
            mostrarMensaje(binding.btnToggle, "Botón inactivo")
        }
    }

    fun escucharEventoSwitch(){
        if(binding.btnSwitch.isChecked){
            mostrarMensaje(binding.btnSwitch, "Botón activo")
        }else{
            mostrarMensaje(binding.btnSwitch, "Botón inactivo")
        }
    }

    fun escucharEventoImagen(){
        mostrarMensaje(binding.btnImage, "Botón de la imagen")
    }

    fun escucharEventoFlotante(){
        mostrarMensaje(binding.btnFlotante, "Botón flotante")
    }

    fun escucharEventoFlotanteTexto(){
        mostrarMensaje(binding.btnFlotanteTexto, "Botón flotante texto")
    }
    **/

    /**
    override fun onPause() {
        super.onPause()
        Log.e("RegistroActivity", "onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("RegistroActivity", "onResume()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("RegistroActivity", "onDestroy()")

    }
    **/
}