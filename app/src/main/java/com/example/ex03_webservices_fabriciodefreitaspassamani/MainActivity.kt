package com.example.ex03_webservices_fabriciodefreitaspassamani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import com.example.ex03_webservices_fabriciodefreitaspassamani.ui.MainFragment
import com.example.ex03_webservices_fabriciodefreitaspassamani.util.*
import com.example.ex03_webservices_fabriciodefreitaspassamani.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    // ViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adicionando máscara no EditText
        etCep.addTextChangedListener(MaskEditUtil.mask(etCep))

        // Funções do botão enviar
        btnSend.setOnClickListener {
            if(etCep.text.toString().length == 9) {
                // Enviando CEP para o ViewModel
                viewModel.setCep(etCep.text.toString())
                tvInit.visibility = View.GONE
                MainFragment.newInstance().loadFragment(this)
            }
            else {
                it.toast(getString(R.string.error_numbers))
            }
        }
    }
}