package co.edu.eam.unilocal_prueba.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.edu.eam.unilocal_prueba.bd.Categorias
import co.edu.eam.unilocal_prueba.bd.Ciudades
import co.edu.eam.unilocal_prueba.bd.Lugares
import co.edu.eam.unilocal_prueba.databinding.ActivityCrearLugarBinding
import co.edu.eam.unilocal_prueba.models.Categoria
import co.edu.eam.unilocal_prueba.models.Ciudad
import co.edu.eam.unilocal_prueba.models.Lugar
import co.edu.eam.unilocal_prueba.R

class CrearLugarActivity : AppCompatActivity() {

    lateinit var binding: ActivityCrearLugarBinding
    lateinit var ciudades: ArrayList<Ciudad>
    lateinit var categorias: ArrayList<Categoria>
    var posCiudad: Int = -1
    var posCategoria: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCrearLugarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ciudades = Ciudades.listar()
        cargarCiudades()

        categorias = Categorias.listar()
        cargarCategorias()

        binding.btnCrearLugar.setOnClickListener { crearNuevoLugar() }

    }

    fun cargarCiudades(){

        var listaCiudades = ciudades.map { c -> c.nombre }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCiudades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ciudadLugar.adapter = adapter
        binding.ciudadLugar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //Aquí debería aparecer el object resaltado en rojo para poder implementar los dos métodos requeridos.
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(baseContext, "El elemento seleccionado fue ${parent!!.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
                posCiudad = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    fun cargarCategorias(){

        var listaCategorias = categorias.map { c -> c.nombre }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCategorias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.categoriaLugar.adapter = adapter
        binding.categoriaLugar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //Aquí debería aparecer el object resaltado en rojo para poder implementar los dos métodos requeridos.
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(baseContext, "El elemento seleccionado fue ${parent!!.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
                posCategoria = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    fun crearNuevoLugar(){

        val nombre = binding.nombreLugar.text.toString()
        val descripcion = binding.descripcionLugar.text.toString()
        val direccion = binding.direccionLugar.text.toString()
        val telefono = binding.telefonoLugar.text.toString()
        val idCiudad = ciudades[posCiudad].id
        val idCategoria = categorias[posCategoria].id

        if (nombre.isEmpty()){
            binding.nombreLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.nombreLayout.error = null
        }

        if (descripcion.isEmpty()){
            binding.descripcionLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.descripcionLayout.error = null
        }

        if (direccion.isEmpty()){
            binding.direccionLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.direccionLayout.error = null
        }

        if (telefono.isEmpty()){
            binding.telefonoLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.telefonoLayout.error = null
        }

        if (nombre.isNotEmpty() && descripcion.isNotEmpty() && direccion.isNotEmpty() && telefono.isNotEmpty() && idCiudad != -1 && idCategoria != -1){

            val lugar = Lugar(7, nombre, descripcion, 1, false, idCategoria, direccion, 0f, 0f, idCiudad)
            val telefonos: ArrayList<String> = ArrayList()
            telefonos.add(telefono)
            lugar.telefonos = telefonos

            Lugares.crear(lugar)

            Log.e("CrearLugarActivity", Lugares.listarRechazados().toString())
        }


    }
}