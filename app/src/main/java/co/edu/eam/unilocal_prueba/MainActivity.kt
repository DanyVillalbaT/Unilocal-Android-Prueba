package co.edu.eam.unilocal_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irARegistro(v: View){
        //Imprimir mensaje en consola, hay diferentes tipos, de error, warning , etc
        Log.e("MainActivity", "Se escucha el evento del click")
        val intentRegistro = Intent(this, RegistroActivity::class.java)
        startActivity(intentRegistro)
    }

    fun irALogin(v: View){
        //Imprimir mensaje en pantalla, un mensaje flotante corto o largo
        Toast.makeText(this, "Se dió click al botón del login", Toast.LENGTH_LONG).show()
        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
    }

    fun irACrearLugar(v: View){
        //Hay diferentes maneras de imprimir mensajes en pantalla, unos más elaborados que otros.
        val intentCrearLugar = Intent(this, CrearLugarActivity::class.java)
        startActivity(intentCrearLugar)

    }
}