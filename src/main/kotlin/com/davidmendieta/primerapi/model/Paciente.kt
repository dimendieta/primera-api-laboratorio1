package com.davidmendieta.primerapi.model


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Paciente")
class Paciente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var cedula:Long?=null
    var name: String? = null
    var apellido: String?= null
    var age: Long? = null
    var tipo_sangre: String?=null
}

