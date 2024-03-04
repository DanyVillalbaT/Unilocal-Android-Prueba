package co.edu.eam.unilocal_prueba.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ToggleButton
import co.edu.eam.unilocal_prueba.R
import co.edu.eam.unilocal_prueba.databinding.ActivityRegistroBinding
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {

    //Lo comentado es de las clases 8 y 9 PDFs y el video.

    lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToggle.setOnClickListener {escucharEventoToggle()}

        binding.btnSwitch.setOnClickListener {escucharEventoSwitch()}

        binding.btnImage.setOnClickListener {escucharEventoImagen()}

        binding.btnFlotante.setOnClickListener {escucharEventoFlotante()}

        binding.btnFlotanteTexto.setOnClickListener {escucharEventoFlotanteTexto()}

        //Log.e("RegistroActivity", "onCreate()")
    }

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