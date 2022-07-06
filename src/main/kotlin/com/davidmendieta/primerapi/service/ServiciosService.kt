package com.davidmendieta.primerapi.service

import com.davidmendieta.primerapi.dto.ActualizarNuevoServicio
import com.davidmendieta.primerapi.model.Servicios
import com.davidmendieta.primerapi.repository.ServiciosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException


@Service
class ServiciosService {

    @Autowired
    lateinit var serviciosRepository: ServiciosRepository

    fun list(): List <Servicios>{
    return serviciosRepository.findAll()
    }

    fun getById (id: Long?): Servicios? {
        return serviciosRepository.findById(id)
    }

    fun getByServicios (nombre_servicio: String?): List<Servicios>? {
        return serviciosRepository.getListadeServicios(nombre_servicio)
    }

    fun getByServiciosCostos (costo: String?): List<Servicios>? {
        return serviciosRepository.getListadeServiciosCostos(costo)
    }

    fun save(servicios: Servicios): Servicios{
        try {
            servicios.nombre_servicio?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Descripción no debe ser vacio")

            return serviciosRepository.save(servicios)

        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }


    fun update (servicios: Servicios):Servicios{
        serviciosRepository.findById(servicios.id) ?: throw Exception()
        return serviciosRepository.save(servicios)
    }

    fun updateName (servicios: Servicios): Servicios {
        try {
            val response = serviciosRepository.findById(servicios.id)
                    ?: throw Exception("El id ${servicios.id} del servicio no existe")
            response.apply {
                this.nombre_servicio = servicios.nombre_servicio
            }
            return serviciosRepository.save(servicios)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    @Transactional
    fun updateOtherNombreServicio  (actualizarNuevoServicio: ActualizarNuevoServicio ): String {
        val rowsUpdate=serviciosRepository.setOtherNombreServicio(actualizarNuevoServicio.nombreServicio,actualizarNuevoServicio.actualizarServicio)
        return "${rowsUpdate} rows updated"

    }

    fun delete (id:Long): Boolean{
        serviciosRepository.deleteById(id)
        return true
    }


    fun validateSerialNumber (serial:String?): Boolean? {

        serial.takeIf { !it?.trim().isNullOrEmpty() }
                ?: throw Exception()

        if (serial?.substring(0, 3).equals("786"))
            return true

        return false


    }

    fun multiplicacion (coeficiente: Int, digito: Int): Int {
   val response= coeficiente*digito
        if(response>=10){
            return response-9
        }
        return response
    }


    fun sumaValores(nui: String):Long{

        var sum:Long=0
        for ( i in 0..8){
            val coeficiente = if( i % 2 ==0) 2 else 1
            sum  += multiplicacion(coeficiente,Integer.parseInt(nui[i].toString()) )
        }
        return sum
    }

    fun findDecenaSuperior (sum: Int): Int { // buscar la decena superior

        val division:Int = sum/10
        val decenaSuperior :Int = (division+1) * 10
        var response:Int=decenaSuperior-sum
        if (response==10)
           response=0
            return response


    }

    fun ultimoDigito(cedula:String):Int {
        val ultimo=cedula.last().toString()
        val response= Integer.parseInt(ultimo)
        return response
    }

    fun validarTotal(cedula: String):Boolean{
        val suma=sumaValores(cedula).toInt()
        val resto=findDecenaSuperior(suma)
        val ultimoDigito=ultimoDigito(cedula)

        return resto ==ultimoDigito

    }

    /*fun validarCedula(sum: Int): Int { // buscar la decena superior

        val division:Int = sum/10
        val decenaSuperior :Int = (division+1) * 10
        var response:Int=decenaSuperior-sum
        if (response==10)
            response=0
        return response


    }*/


}