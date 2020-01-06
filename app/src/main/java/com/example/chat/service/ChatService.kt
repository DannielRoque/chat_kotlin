package com.example.chat.service

import com.example.chat.model.Mensagem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

const val URLBASE = "http://172.19.248.134:8080"

interface ChatService {

    @POST("polling")
    fun enviar(@Body mensagem: Mensagem) {
    }

    @GET("polling")
    fun ouvirMensagem() {


    }
}
