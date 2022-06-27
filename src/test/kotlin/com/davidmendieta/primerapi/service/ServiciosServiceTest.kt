package com.davidmendieta.primerapi.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ServiciosServiceTest {

    @Autowired
    lateinit var serviciosService: ServiciosService

    @Test
    fun validateSerialIsValid(){
        val response =  serviciosService.validateSerialNumber("74123658")
        Assertions.assertEquals(true,response)
    }

    @Test
    fun validateSerialIsInvalid(){
        val response =  serviciosService.validateSerialNumber("47856958")
        Assertions.assertEquals(false,response)
    }

    @Test
    fun validateSerialIsBlank(){
        Assertions.assertThrows(Exception::class.java) {
            val response = serviciosService.validateSerialNumber("")

        }
    }

    @Test
    fun validateSerialIsincomplete(){
        Assertions.assertThrows(Exception::class.java) {
            val response = serviciosService.validateSerialNumber("1")

        }
    }









}