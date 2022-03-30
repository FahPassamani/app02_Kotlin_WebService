package com.example.ex03_webservices_fabriciodefreitaspassamani.model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitBuilder(cep: String){

    val cep = cep
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/${cep}/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}


