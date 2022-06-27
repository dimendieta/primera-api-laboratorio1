package com.davidmendieta.primerapi.controller

import com.davidmendieta.primerapi.model.Citas
import com.davidmendieta.primerapi.model.Paciente
import com.davidmendieta.primerapi.service.PacienteService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pacientes")
class PacienteController {

    @Autowired
    lateinit var pacienteService: PacienteService

    @GetMapping
    fun list():List<Paciente>{
       return pacienteService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long) : Paciente?{
        return pacienteService.getById(id)
    }

    //Query String Nombre
    //localhost:8081/paciente/name/David
    @GetMapping("/name/{name}")
    fun lisByNombres(@PathVariable("name") name: String): List<Paciente>?{
        return pacienteService.getByNombres(name)
    }


    //Query Number Age
    //localhost:8081/paciente/age/18
    @GetMapping("/age/{age}")
    fun lisByAge(@PathVariable("age") age: Long): List<Paciente>?{
        return pacienteService.getByAge(age)
    }


    //Query String Tipo_Sangre
    //localhost:8081/paciennte/tipo_sangre/covid
    @GetMapping("/tipo_sangre/{tipo_sangre}")
    fun lisByPacienteSangre(@PathVariable("tipo_sangre") tipo_sangre: String): List<Paciente>?{
        return pacienteService.getByPacienteSangre(tipo_sangre)
    }




    @PostMapping
    fun save(@RequestBody paciente: Paciente):Paciente{
        return pacienteService.save(paciente)
    }

   @PutMapping
    fun update(@RequestBody  paciente : Paciente):Paciente{
          return pacienteService.update(paciente)
    }

   @PatchMapping
   fun updateName(@RequestBody paciente: Paciente): Paciente{
       return  pacienteService.updateName(paciente)

   }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return pacienteService.delete(id)
    }


}




