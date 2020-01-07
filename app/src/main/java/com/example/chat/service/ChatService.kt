package com.example.chat.service

import com.example.chat.model.Mensagem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST



interface ChatService {

    @POST("polling")
    fun enviar(@Body mensagem: Mensagem) : Call<Unit>

    @GET("polling")
     fun ouvirMensagem()  : Call<Mensagem>
}
