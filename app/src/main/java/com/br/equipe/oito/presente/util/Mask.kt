package com.br.equipe.oito.presente.util

import android.text.Editable

import android.text.TextWatcher
import android.widget.EditText

object Mask {
    const val FORMAT_CPF = "###.###.###-##"
    const val FORMAT_CNPJ = "##.###.###/####-##"
    const val FORMAT_FONE = "(##)#####-####"
    const val FORMAT_CEP = "#####-###"

    fun unmask(s: String): String {
        return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
            .replace("[)]".toRegex(), "")
    }

    fun insert(mask: String, ediTxt: EditText): TextWatcher {
        return object : TextWatcher {
            var isUpdating = false
            var old = ""
            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) {
                val str = unmask(s.toString())
                var mascara = ""
                if (isUpdating) {
                    old = str
                    isUpdating = false
                    return
                }
                var i = 0
                for (m in mask.toCharArray()) {
                    if (m != '#' && str.length > old.length) {
                        mascara += m
                        continue
                    }
                    mascara += try {
                        str[i]
                    } catch (e: Exception) {
                        break
                    }
                    i++
                }
                isUpdating = true
                ediTxt.setText(mascara)
                ediTxt.setSelection(mascara.length)
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        }
    }

    fun insertBankMask(editText: EditText?): TextWatcher {
        return object : TextWatcher {
            var old = ""
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(string: CharSequence?, start: Int, count: Int, after: Int) {
                string?.let { s ->
                    var new = s.toString().replace("-", "")

                    if (new != old) {
                        old = new
                        new = if (new.length > 4) {
                            new.substring(0, new.length - 1) + "-" + new.substring(
                                new.length - 1,
                                new.length
                            )
                        } else {
                            new
                        }
                        editText?.setText(new)
                        editText?.setSelection(new.length)
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        }
    }
}