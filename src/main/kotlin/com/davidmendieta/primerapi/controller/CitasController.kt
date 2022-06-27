package com.davidmendieta.primerapi.controller

import com.davidmendieta.primerapi.model.Citas
import com.davidmendieta.primerapi.model.Paciente
import com.davidmendieta.primerapi.service.CitasService
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
@RequestMapping("/citas")
class CitasController {

    @Autowired
    lateinit var citasService: CitasService

    @GetMapping
    fun list () : List <Citas>{
        return citasService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long) : Citas?{
        return citasService.getById(id)
    }


    @GetMapping("/fecha/{fecha}")
    fun lisByAge(@PathVariable("fecha") fecha:String): List<Citas>?{
        return citasService.getByCitas(fecha)
    }

    @GetMapping("/hora/{hora}")
    fun lisByHora(@PathVariable("hora") hora:String): List<Citas>?{
        return citasService.getByCitasHora(hora)
    }







    @PostMapping
    fun save(@RequestBody citas: Citas):Citas{
        return citasService.save(citas)
    }

    @PutMapping
    fun update(@RequestBody citas: Citas):Citas{
        return citasService.update(citas)
    }
    @PatchMapping
    fun updateName(@RequestBody citas: Citas):Citas{
        return citasService.updateName(citas)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return citasService.delete(id)
    }
}