package com.example.ex03_webservices_fabriciodefreitaspassamani.model
import retrofit2.http.GET

interface ApiService {
    @GET("json/")
    suspend fun getCep(): Cep
}