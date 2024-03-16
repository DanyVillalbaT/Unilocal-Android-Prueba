package co.edu.eam.unilocal_prueba.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.edu.eam.unilocal_prueba.R
import co.edu.eam.unilocal_prueba.bd.Lugares
import co.edu.eam.unilocal_prueba.databinding.ActivityDetalleLugarBinding

class DetalleLugarActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetalleLugarBinding
    var codigoLugar: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalleLugarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        codigoLugar = intent.extras!!.getInt("codigo")
        val lugar = Lugares.obtener(codigoLugar)
        Toast.makeText(this, "${lugar.toString()}", Toast.LENGTH_LONG).show()
    }
}