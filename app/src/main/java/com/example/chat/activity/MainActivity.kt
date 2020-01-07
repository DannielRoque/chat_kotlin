package com.example.chat.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.chat.R
import com.example.chat.adapter.MensagemAdapter
import com.example.chat.callback.EnviarMensagemCallback
import com.example.chat.callback.OuvirMensagensCallback
import com.example.chat.model.Mensagem
import com.example.chat.service.ChatService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URLBASE = "http://172.19.248.134:8080/"
//177.129.4.51

class MainActivity : AppCompatActivity() {

    private var id = 1
    private var mensagens = ArrayList<Mensagem>()
    private lateinit var chatService : ChatService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lv_mensagens.adapter = MensagemAdapter(mensagens, this, id)

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(URLBASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        chatService = retrofit.create(ChatService::class.java)

        ouvirMensagem()

        btn_enviar.setOnClickListener {
            chatService.enviar(Mensagem(et_texto.text.toString(), id)).enqueue(
                EnviarMensagemCallback()
            )
        }
    }

    fun colocaNaLista(mensagem: Mensagem) {
        mensagens.add(mensagem)
        Log.e("Chat", "MainActivity $mensagens")
        val adapter = MensagemAdapter(mensagens, this, id)
        lv_mensagens.adapter = adapter

        ouvirMensagem()
    }

    fun ouvirMensagem(){
        val call : Call<Mensagem> = chatService.ouvirMensagem()
        call.enqueue(OuvirMensagensCallback(this))
    }
}
