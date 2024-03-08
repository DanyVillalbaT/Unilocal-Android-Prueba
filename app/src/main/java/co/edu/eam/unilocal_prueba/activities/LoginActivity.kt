package co.edu.eam.unilocal_prueba.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    fun login(){

        val correo = binding.emailUsuario.text
        val password = binding.passwordUsuario.text

        if (correo.isEmpty()){
            binding.emailLayout.error = "Obligatorio"
        }else{
            binding.emailLayout.error = null
        }

        if (password.isEmpty()){
            binding.passwordLayout.error = "Obligatorio"
        }else{
            binding.passwordLayout.error = null
        }

        if (correo.isNotEmpty() && password.isNotEmpty()){

            try {
                val usuario = Usuarios.login(correo.toString(), password.toString())
                Toast.makeText(this, "Sus datos son correctos", Toast.LENGTH_LONG).show()

            }catch (e:Exception){
                Toast.makeText(this, "Sus datos son incorrectos", Toast.LENGTH_LONG).show()

            }

        }

    }
}