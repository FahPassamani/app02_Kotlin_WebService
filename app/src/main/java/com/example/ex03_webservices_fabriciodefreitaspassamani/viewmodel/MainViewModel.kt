package com.example.ex03_webservices_fabriciodefreitaspassamani.viewmodel

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ex03_webservices_fabriciodefreitaspassamani.model.ApiHelper
import com.example.ex03_webservices_fabriciodefreitaspassamani.model.Cep
import com.example.ex03_webservices_fabriciodefreitaspassamani.model.RetrofitBuilder
import kotlinx.coroutines.launch

 class MainViewModel: ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()
    val errorType = MutableLiveData<Int>()
    val cep = MutableLiveData<Cep>()

     // Recebendo CEP
    fun setCep(cep: String?) {
        if (cep != null) {
            fetchCep(cep)
        }
    }

    // Pegando CEP com coroutines
    private fun fetchCep(str: String) {
        loading.value = true
        // Corroutine
        val launch = viewModelScope.launch {
            try {
                val currentCep = ApiHelper(RetrofitBuilder(str).apiService).getCep()
                if (currentCep.erro != null) {
                    error.value = true
                    errorType.value = 1
                    loading.value = false
                } else {
                    cep.value = currentCep
                    error.value = false
                    loading.value = false
                }
            } catch (e: Exception) {
                error.value = true
                errorType.value = 0
                loading.value = false
            }
        }
    }
}