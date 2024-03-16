package co.edu.eam.unilocal_prueba.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.eam.unilocal_prueba.R
import co.edu.eam.unilocal_prueba.adapters.LugarAdapter
import co.edu.eam.unilocal_prueba.bd.Lugares
import co.edu.eam.unilocal_prueba.databinding.ActivityResultadoBusquedaBinding
import co.edu.eam.unilocal_prueba.models.Lugar

class ResultadoBusquedaActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultadoBusquedaBinding
    var textoBusqueda: String = ""
    lateinit var listaLugares: ArrayList<Lugar>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBusquedaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textoBusqueda = intent.extras!!.getString("textoBusqueda", "")
        listaLugares = ArrayList()

        if (textoBusqueda.isNotEmpty()){
            listaLugares = Lugares.buscarNombre(textoBusqueda)
            Log.e("ResultadoBusquedaActivity", listaLugares.toString())
        }

        val adapter = LugarAdapter(listaLugares)
        binding.listaLugares.adapter = adapter
        binding.listaLugares.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}