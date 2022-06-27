package com.davidmendieta.primerapi.service


import com.davidmendieta.primerapi.dto.UsuarioDTO
import com.davidmendieta.primerapi.model.Usuario

import com.davidmendieta.primerapi.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional

@Service
class UsuarioService {

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun list(): List <Usuario>{
        return usuarioRepository.findAll()
    }

    fun getById (id: Long?): Usuario? {
        return usuarioRepository.findById(id)
    }

    fun getByUsuario (username: String?): List<Usuario>? {
        return usuarioRepository.getListadeUsuario(username)
    }

    fun getByUsuarios (password: String?): List<Usuario>? {
        return usuarioRepository.getListadeUsuarios(password)
    }


    fun save(usuario: Usuario): Usuario{
        try {
            usuario.username?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Descripción no debe ser vacio")

            return usuarioRepository.save(usuario)

        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }


    fun update (usuario: Usuario):Usuario{
        usuarioRepository.findById(usuario.id) ?: throw Exception()
        return usuarioRepository.save(usuario)
    }

    fun updateName (usuario: Usuario): Usuario {
        try {
            val response = usuarioRepository.findById(usuario.id)
                    ?: throw Exception("El id ${usuario.id} del servicio no existe")
            response.apply {
                this.username = usuario.username
            }
            return usuarioRepository.save(usuario)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    @Transactional
     fun updateOtherNombreUsuarios (usuarioDTO: UsuarioDTO ): String {
        val rowsUpdate=usuarioRepository.setOtherNombreUsuario(usuarioDTO.username, usuarioDTO.password)
        return "${rowsUpdate} rows updated"


    }

    fun delete (id:Long): Boolean{
        usuarioRepository.deleteById(id)
        return true
    }




}