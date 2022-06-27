package com.davidmendieta.primerapi.service

import com.davidmendieta.primerapi.model.Citas
import com.davidmendieta.primerapi.model.Paciente
import com.davidmendieta.primerapi.repository.CitasRepository
import com.davidmendieta.primerapi.repository.PacienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class PacienteService {

    @Autowired
    lateinit var pacienteRepository: PacienteRepository


    fun list (): List <Paciente>{
        return pacienteRepository.findAll()
    }

    fun getById (id: Long?): Paciente? {
        return pacienteRepository.findById(id)
    }

    fun getByAge (age: Long?): List<Paciente>? {
        return pacienteRepository.getListadePacientes(age)
    }
    fun getByPacienteSangre (tipo_sangre: String?): List<Paciente>? {
        return pacienteRepository.getListadePacientesSangre(tipo_sangre)
    }
    fun getByNombres(name: String?): List<Paciente>? {
        return pacienteRepository.getListadeNombres(name)
    }

    fun save(paciente: Paciente):Paciente{
        try {
            paciente.name?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Descripción no debe ser vacio")

            return pacienteRepository.save(paciente)

        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    //Update tb set name="david" where id=4
    fun update (paciente: Paciente): Paciente{
        pacienteRepository.findById(paciente.id) ?: throw Exception()
        return pacienteRepository.save(paciente)
    }

    fun delete (id:Long): Boolean{
        pacienteRepository.deleteById(id)
        return true
    }

    fun updateName (paciente: Paciente):Paciente {
        try {
            val response = pacienteRepository.findById(paciente.id)
                    ?: throw Exception("El id ${paciente.id} del paciente no existe")
            response.apply {
                this.cedula = paciente.cedula
            }
            return pacienteRepository.save(paciente)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)


        }





}
}











