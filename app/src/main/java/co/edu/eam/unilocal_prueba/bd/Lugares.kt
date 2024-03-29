package co.edu.eam.unilocal_prueba.bd

import co.edu.eam.unilocal_prueba.models.Horario
import co.edu.eam.unilocal_prueba.models.Lugar

object Lugares {

    private val lugares: ArrayList<Lugar> = ArrayList()

    init {
        val horario1 = Horario(1, Horarios.obtenerTodos(), 12, 20)
        val horario2 = Horario(1, Horarios.obtenerEntreSemana(), 9, 20)
        val horario3 = Horario(1, Horarios.obtenerFinSemana(), 14, 23)

        val lugar1 = Lugar(1, "Café ABC", "Excelente café para compartir", 1, true, 2, "calle 123",73.3434f, -40.4345f, 1)
        lugar1.horarios.add(horario2)

        val lugar2 = Lugar(2, "Bar City Pub", "Bar en la ciudad de Armenia", 2, true, 5, "calle 456",73.3534f, -41.4345f, 1)
        lugar2.horarios.add(horario1)

        val lugar3 = Lugar(3, "Restaurante Mi Cuate", "Comida mexicana para todos", 3, true, 3, "calle 789",73.3434f, -40.4345f, 5)
        lugar3.horarios.add(horario1)

        val lugar4 = Lugar(4, "BBC Norte Pub", "Cervezas BBC muy buenas", 1, true, 5, "calle 147",73.3434f, -40.4345f, 3)
        lugar4.horarios.add(horario3)

        val lugar5 = Lugar(5, "Hotel Barato", "Hotel para ahorrar mucho dinero", 1, true, 1, "calle 258",73.3434f, -40.4345f, 4)
        lugar5.horarios.add(horario1)

        val lugar6 = Lugar(1, "Hostal Hippie", "Alojamiento para todos y todas", 2, false, 1, "calle 369",73.3434f, -40.4345f, 2)
        lugar6.horarios.add(horario2)

        lugares.add(lugar1)
        lugares.add(lugar2)
        lugares.add(lugar3)
        lugares.add(lugar4)
        lugares.add(lugar5)
        lugares.add(lugar6)

    }

    fun listarAprobados(): ArrayList<Lugar> {
        return lugares.filter { l -> l.estado}.toCollection(ArrayList())
    }

    fun listarRechazados(): ArrayList<Lugar> {
        return lugares.filter { l -> !l.estado}.toCollection(ArrayList())
    }

    fun obtener(id: Int): Lugar?{
        return lugares.firstOrNull { l -> l.id == id }
    }

    fun buscarNombre(nombre: String): ArrayList<Lugar> {
        return lugares.filter { l -> l.nombre.lowercase().contains(nombre.lowercase()) && l.estado}.toCollection(ArrayList())
    }

    fun crear(lugar: Lugar){
        lugares.add(lugar)
    }

    fun buscarCiudad(idCiudad: Int): ArrayList<Lugar> {
        return lugares.filter { l -> l.idCiudad == idCiudad && l.estado }.toCollection(ArrayList())
    }

    fun buscarCategoria(idCategoria: Int): ArrayList<Lugar> {
        return lugares.filter { l -> l.idCategoria == idCategoria && l.estado }.toCollection(ArrayList())
    }
}