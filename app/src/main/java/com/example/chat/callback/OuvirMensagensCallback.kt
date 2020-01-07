package com.example.chat.callback

import com.example.chat.activity.MainActivity
import com.example.chat.model.Mensagem
import retrofit2.Call
import retrofit2.Response

open class OuvirMensagensCallback(
    private val activity: MainActivity
) : retrofit2.Callback<Mensagem> {

    override fun onFailure(call: Call<Mensagem>, t: Throwable) {
        activity.ouvirMensagem()
    }

    override fun onResponse(call: Call<Mensagem?>, response: Response<Mensagem?>) {
        if (response.isSuccessful){
    val mensagem = response.body()
            if (mensagem != null) {
                activity.colocaNaLista(mensagem)
            }
        }
    }

}