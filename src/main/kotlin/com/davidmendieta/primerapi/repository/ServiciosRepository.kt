package com.davidmendieta.primerapi.repository


import com.davidmendieta.primerapi.model.Paciente
import com.davidmendieta.primerapi.model.Servicios
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface ServiciosRepository:JpaRepository<Servicios,Long> {
    fun findById (id: Long?): Servicios?

    @Query(nativeQuery = true)
    fun getListadeServicios(@Param("nombre_servicio") nombre_servicio:String?): List <Servicios>?

    @Query(nativeQuery = true)
    fun getListadeServiciosCostos(@Param("costo") costo:String?): List <Servicios>?

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    fun setOtherNombreServicio( @Param ("nombreServicio") nombreServicio: String? , @Param("actualizarServicio") actualizarServicio: String?) : Integer?

}