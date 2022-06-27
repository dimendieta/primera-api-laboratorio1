package com.davidmendieta.primerapi.service

import com.davidmendieta.primerapi.model.Citas
import com.davidmendieta.primerapi.model.Servicios

import com.davidmendieta.primerapi.repository.CitasRepository
import com.davidmendieta.primerapi.repository.PacienteRepository


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CitasService {

    @Autowired
    lateinit var citasRepository: CitasRepository

    @Autowired
    lateinit var pacienteRepository: PacienteRepository

    fun list (): List <Citas>{
        return citasRepository.findAll()
    }

    fun getById (id: Long?): Citas? {
        return citasRepository.findById(id)
    }

    fun getByCitas (fecha: String?): List<Citas>? {
        return citasRepository.getListadeCitas(fecha)
    }

    fun getByCitasHora (hora: String?): List<Citas>? {
        return citasRepository.getListadeCitasHora(hora)
    }


    fun save(citas: Citas): Citas{
        try {
            citas.fecha?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("La fecha no puede estar vacia")

            pacienteRepository.findById(citas.pacienteId)
                    ?: throw Exception("El id del paciente no existe")

            return citasRepository.save(citas)


        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }


    fun update (citas: Citas):Citas{
        citasRepository.findById(citas.id) ?: throw Exception()
        return citasRepository.save(citas)
    }
    fun updateName (citas: Citas): Citas {
        try {
            val response = citasRepository.findById(citas.id)
                    ?: throw Exception("El id ${citas.id} del paciente no existe")
            response.apply {
                this.fecha = citas.fecha
            }
            return citasRepository.save(citas)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }


    fun delete (id:Long): Boolean{
        citasRepository.deleteById(id)
        return true
    }
}