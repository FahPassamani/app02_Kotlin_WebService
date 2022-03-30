package com.example.ex03_webservices_fabriciodefreitaspassamani.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.ex03_webservices_fabriciodefreitaspassamani.R


/*
class Utils {
}*/

object MaskEditUtil {
    fun mask(ediTxt: EditText): TextWatcher {
        return object : TextWatcher {
            var isUpdating: Boolean = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val str = unmask(s.toString())
                var mascara = ""
                val mask = "#####-###"
                if (isUpdating) {
                    isUpdating = false
                    return
                }
                var i = 0
                for (m in mask.toCharArray()) {
                    if (m != '#' && count > before) {
                        mascara += m
                        continue
                    }
                    try {
                        mascara += str[i]
                    } catch (e: Exception) {
                        break
                    }
                    i++
                }
                isUpdating = true
                ediTxt.setText(mascara)
                ediTxt.setSelection(mascara.length)
            }
            override fun afterTextChanged(s: Editable?) {}
        }
    }
    fun unmask(s: String): String {
        return s.replace("-", "")
    }
}
// Carregar Fragment
fun Fragment.loadFragment(act: FragmentActivity) {
    act.supportFragmentManager.beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.fragment, this)
        .commitNow()
}
// Toast
fun View.toast(str: String){
    Toast.makeText(context , str, Toast.LENGTH_SHORT).show()
}
