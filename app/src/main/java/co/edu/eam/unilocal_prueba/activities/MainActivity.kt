package co.edu.eam.unilocal_prueba.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import co.edu.eam.unilocal_prueba.R

class MainActivity : AppCompatActivity() {

    //Lo que está comentado hace referencia a las clases 8 y 9 de los PDFs y videos

    /*lateinit var texto: TextView
    lateinit var textoInicial: String*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*texto = findViewById(R.id.texto_inicial)

        if (savedInstanceState != null){
            textoInicial = savedInstanceState.getString("texto").toString()
            texto.text = textoInicial
        }else{
            textoInicial = "Texto Inicial"
            texto.text = textoInicial
        }*/

        Log.e("MainActivity", "onCreate()")
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("texto", textoInicial)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("MainActivity", savedInstanceState.getString("texto").toString())
    }*/

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "onRestart()")
    }

    /* Método de la clase 11 PDF y su video
    fun irARegistro(v: View){
        //Imprimir mensaje en consola, hay diferentes tipos, de error, warning , etc
        Log.e("MainActivity", "Se escucha el evento del click")
        val intentRegistro = Intent(this, RegistroActivity::class.java)
        startActivity(intentRegistro)
    }
     */

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

    /*fun cambiarTexto(v: View){
        textoInicial = "Nuevo valor"
        texto.text = textoInicial
    }*/
}