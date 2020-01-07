package com.example.chat.model

import com.google.gson.annotations.SerializedName

class Mensagem(
    @SerializedName("text")
    val texto : String,
    var id : Int
)
