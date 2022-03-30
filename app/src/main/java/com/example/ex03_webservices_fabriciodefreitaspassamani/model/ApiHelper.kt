package com.example.ex03_webservices_fabriciodefreitaspassamani.model

class ApiHelper(private val apiService: ApiService) {
    suspend fun getCep() = apiService.getCep()
}