package co.edu.eam.unilocal_prueba.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.unilocal_prueba.models.Lugar
import co.edu.eam.unilocal_prueba.R
import co.edu.eam.unilocal_prueba.activities.DetalleLugarActivity

class LugarAdapter(var listaLugares: ArrayList<Lugar>): RecyclerView.Adapter<LugarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_lugar, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaLugares[position])
    }

    override fun getItemCount() = listaLugares.size

    inner class ViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val nombre: TextView = itemView.findViewById(R.id.nombre_lugar)
        val direccion: TextView = itemView.findViewById(R.id.direccion_lugar)
        val estado: TextView = itemView.findViewById(R.id.estado_lugar)
        val horario: TextView = itemView.findViewById(R.id.horario_lugar)
        val imagen: ImageView = itemView.findViewById(R.id.imagen_lugar)
        var codigo: Int = 0

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(lugar: Lugar){
            nombre.text = lugar.nombre
            direccion.text = lugar.direccion
            estado.text = "Abierto"
            horario.text = "Cierra a las 2:00"
            codigo = lugar.id
        }

        override fun onClick(v: View?) {
            val intent = Intent(nombre.context, DetalleLugarActivity::class.java)
            intent.putExtra("codigo", codigo)
            nombre.context.startActivity(intent)
        }

    }
}