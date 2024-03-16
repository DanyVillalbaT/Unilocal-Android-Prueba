package co.edu.eam.unilocal_prueba.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import co.edu.eam.unilocal_prueba.R
import co.edu.eam.unilocal_prueba.bd.Usuarios
import co.edu.eam.unilocal_prueba.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { login() }
        binding.btnRegistro.setOnClickListener { irARegistrarse() }
    }

    fun login(){

        val correo = binding.emailUsuario.text
        val password = binding.passwordUsuario.text

        if (correo.isEmpty()){
            binding.emailLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.emailLayout.error = null
        }

        if (password.isEmpty()){
            binding.passwordLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.passwordLayout.error = null
        }

        if (correo.isNotEmpty() && password.isNotEmpty()){

            try {
                Usuarios.login(correo.toString(), password.toString())
                Toast.makeText(this, getString(R.string.datos_correctos), Toast.LENGTH_LONG).show()

            }catch (e:Exception){
                Toast.makeText(this, getString(R.string.datos_incorrectos), Toast.LENGTH_LONG).show()

            }

        }

    }

    fun irARegistrarse(){
        val intentRegistro = Intent(this, RegistroActivity::class.java)
        startActivity(intentRegistro)
    }
}