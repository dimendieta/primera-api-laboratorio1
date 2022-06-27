package com.davidmendieta.primerapi.controller

import com.davidmendieta.primerapi.dto.UsuarioDTO

import com.davidmendieta.primerapi.model.Usuario
import com.davidmendieta.primerapi.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping
    fun list(): List <Usuario>{
        return usuarioService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long) : Usuario?{
        return usuarioService.getById(id)
    }
    //Query String NombreServicio
    //localhost:8081/login/usuario/david
    @GetMapping("/filter/{username}")
    fun lisBySUsuarios(@PathVariable("username") username: String): List<Usuario>?{
        return usuarioService.getByUsuario(username)
    }

    //Query String Usuarios
    //localhost:8081/login/password/123
    @GetMapping("/login/{password}")
    fun lisByUsuarios(@PathVariable("password") password: String): List<Usuario>?{
        return usuarioService.getByUsuarios(password)
    }


    //Query String Usuarios
    //localhost:8081/login/username
    @PostMapping("/usuario")
    fun updateOtherNombreUsuarios(@RequestBody usuarioDTO: UsuarioDTO): String?{
        return usuarioService.updateOtherNombreUsuarios(usuarioDTO)
    }

    @PostMapping
    fun save (@RequestBody usuario: Usuario): Usuario {
        return usuarioService.save(usuario)
    }
    @PutMapping
    fun update(@RequestBody usuario: Usuario): Usuario {
        return usuarioService.update(usuario)
    }
    @PatchMapping
    fun updateName(@RequestBody usuario: Usuario): Usuario {
        return usuarioService.updateName(usuario)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return usuarioService.delete(id)
    }




}