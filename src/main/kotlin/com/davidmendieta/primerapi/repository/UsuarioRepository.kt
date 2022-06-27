package com.davidmendieta.primerapi.repository




import com.davidmendieta.primerapi.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional


interface UsuarioRepository:JpaRepository<Usuario,Long> {
    fun findById(id: Long?): Usuario?

    @Query(nativeQuery = true)
    fun getListadeUsuario(@Param("username") username:String?): List <Usuario>?

    @Query(nativeQuery = true)
    fun getListadeUsuarios(@Param("password") password:String?): List <Usuario>?

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    fun setOtherNombreUsuario(@Param("username") username: String?, @Param("password") password: String?): Integer?

}