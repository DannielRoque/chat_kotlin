package com.example.chat.callback

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnviarMensagemCallback : Callback<Unit> {
    override fun onFailure(call: Call<Unit>, t: Throwable) {
    }

    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {

    }
}