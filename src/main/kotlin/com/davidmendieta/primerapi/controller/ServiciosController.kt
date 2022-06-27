package com.davidmendieta.primerapi.controller

import com.davidmendieta.primerapi.dto.ActualizarNuevoServicio

import com.davidmendieta.primerapi.model.Servicios
import com.davidmendieta.primerapi.service.ServiciosService
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/servicios")

class ServiciosController {

   @Autowired
   lateinit var serviciosService: ServiciosService

   @GetMapping
   fun list(): List <Servicios>{
       return serviciosService.list()
   }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long) : Servicios?{
        return serviciosService.getById(id)
    }

    //Query String NombreServicio
    //localhost:8081/servicios/nombreservicio/covid
    @GetMapping("/nombre_servicio/{nombre_servicio}")
    fun lisByServicios(@PathVariable("nombre_servicio") nombre_servicio: String): List<Servicios>?{
        return serviciosService.getByServicios(nombre_servicio)
    }

    //Query String ServicioCostos
    //localhost:8081/servicios/costos/20dolares
    @GetMapping("/costo/{costo}")
    fun lisByServiciosCostos(@PathVariable("costo") costo: String): List<Servicios>?{
        return serviciosService.getByServiciosCostos(costo)
    }

    //Query String ServicioCostos
    //localhost:8081/servicios/cambiarNombre
    @PostMapping("/update/nombre")
    fun updateOtherNombreServicio(@RequestBody actualizarNuevoServicio: ActualizarNuevoServicio): String?{
        return serviciosService.updateOtherNombreServicio(actualizarNuevoServicio)
    }

    @PostMapping
    fun save (@RequestBody servicios: Servicios): Servicios{
        return serviciosService.save(servicios)
    }
    @PutMapping
    fun update(@RequestBody servicios: Servicios):Servicios{
        return serviciosService.update(servicios)
    }
    @PatchMapping
    fun updateName(@RequestBody servicios: Servicios):Servicios{
        return serviciosService.updateName(servicios)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return serviciosService.delete(id)
    }













}