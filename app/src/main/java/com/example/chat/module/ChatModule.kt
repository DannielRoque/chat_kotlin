package com.example.chat.module

import com.example.chat.activity.URLBASE
import com.example.chat.service.ChatService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ChatModule {

    @Provides
    fun getChatService() : ChatService{
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(URLBASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ChatService::class.java)
    }
}