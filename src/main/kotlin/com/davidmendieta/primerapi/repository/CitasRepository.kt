package com.davidmendieta.primerapi.repository

import com.davidmendieta.primerapi.model.Citas
import com.davidmendieta.primerapi.model.Servicios

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CitasRepository:JpaRepository<Citas, Long> {
    fun findById(id: Long?):Citas?

    @Query(nativeQuery = true)
    fun getListadeCitas(@Param("fecha") fecha:String?): List <Citas>?

    @Query(nativeQuery = true)
    fun getListadeCitasHora(@Param("hora") hora:String?): List <Citas>?

}