package com.davidmendieta.primerapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "Servicios")
class Servicios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre_servicio: String? = null
    var costo : String? = null
    @Column(name = "paciente_id")
    var pacienteId: Long? = null



}