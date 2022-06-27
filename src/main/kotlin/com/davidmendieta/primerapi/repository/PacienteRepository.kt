package com.davidmendieta.primerapi.repository

import com.davidmendieta.primerapi.model.Paciente

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import javax.persistence.Id

interface PacienteRepository:JpaRepository<Paciente,Long> {
    fun findById(id: Long?): Paciente?

    @Query(nativeQuery = true)
    fun getListadePacientes(@Param("age") age:Long?): List <Paciente>?

    @Query(nativeQuery = true)
    fun getListadePacientesSangre(@Param("tipo_sangre") tipo_sangre:String?): List <Paciente>?

    @Query(nativeQuery = true)
    fun getListadeNombres(@Param("name") name:String?): List <Paciente>?



}
