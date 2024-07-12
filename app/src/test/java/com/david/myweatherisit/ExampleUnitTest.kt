package com.david.myweatherisit

import com.david.myweatherisit.model.apiclient.KtorClient
import com.david.myweatherisit.model.dto.CityResponse
import io.ktor.serialization.JsonConvertException
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import java.util.Objects

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testApiGetRequest(){
        val api = KtorClient()
        runBlocking {
            val res: CityResponse = api.request("Mexicali")
            assertNotNull("Is not null", res.data)
        }
    }

    @Test
    fun testApiGetNull(){
        val api = KtorClient()
        runBlocking {
            val res: CityResponse = api.request("5555")
            assertNull("Is null", res.data[0].clouds)
        }
    }
}