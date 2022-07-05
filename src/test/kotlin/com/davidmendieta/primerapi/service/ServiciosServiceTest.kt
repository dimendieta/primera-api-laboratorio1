package com.davidmendieta.primerapi.service

import com.davidmendieta.primerapi.repository.ServiciosRepository
/*import com.google.gson.Gson*/
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


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

    @Test
    fun multiplicacionWhenLessThanTen (){
   val response= serviciosService.multiplicacion(1,7)
        Assertions.assertEquals(7,response)
    }

    @Test
    fun multiplicacionWhenMajorLessThanTen (){
        val response= serviciosService.multiplicacion(2,7)
        Assertions.assertEquals(5,response)
    }
    @Test
    fun validarSumaNui (){
        val response=serviciosService.sumaValores("0301707030")
        Assertions.assertEquals(20,response)
    }
    @Test
    fun validarDecenaSuperiorCuandoNoesCero (){
        val response=serviciosService.findDecenaSuperior(13)
        Assertions.assertEquals(7,response)
    }
    @Test
    fun validarDecenaSuperiorCuandoesCero (){
        val response=serviciosService.findDecenaSuperior(80)
        Assertions.assertEquals(0,response)
    }

    @Test
    fun ultimoDigito (){
        val response=serviciosService.ultimoDigito("0106430044")
        Assertions.assertEquals(9,response)
    }

    @Test
    fun ultimoDigitoNo (){
        val response=serviciosService.ultimoDigito("0123654789")
        Assertions.assertEquals(5,response)
    }
    @Test
    fun ultimoDiigitoCedula (){
        val response=serviciosService.validarTotal("0106430044")
        Assertions.assertEquals(true,response)
    }
    @Test
    fun ultimoDigit (){
        val response=serviciosService.validarTotal("0106430048")
        Assertions.assertEquals(false,response)
    }


/*
    @InjectMocks
    lateinit var serviciosSeervice: ServiciosService

    @Mock
    lateinit var serviciosRepository: ServiciosRepository

    val jsonString = File("./src/test/resources/product.json").readText(Charsets.UTF_8)
    val productMock = Gson().fromJson(jsonString, Product::class.java)

    @Test
    fun saveProduct(){
        //PAra actualizar
        /// LLAVES  FORENEAS
        //Mockito.`when`(productRepository.findById(productMock.id)).thenReturn(productMock)
        Mockito.`when`(serviciosRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
        val response = serviciosService.save(productMock)
        Assertions.assertEquals(response?.id, productMock.id)
    }

    @Test
    fun saveProductFailed(){
        Assertions.assertThrows(Exception::class.java) {
            productMock.apply { code=" "}
            Mockito.`when`(serviciosRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
            serviciosService.save(productMock)
        }
*/







}