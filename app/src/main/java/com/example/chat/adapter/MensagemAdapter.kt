package com.example.chat.adapter

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.chat.R
import com.example.chat.activity.MainActivity
import com.example.chat.model.Mensagem
import kotlinx.android.synthetic.main.mensagem.view.*

class MensagemAdapter(
    val listaMensagens : MutableList<Mensagem>,
    private val activity: MainActivity,
    private var idDoCliente : Int
) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        Log.e("Chat", "GetView")
        val linha = activity.layoutInflater.inflate(R.layout.mensagem,parent,false)

        var texto : TextView = linha.tv_texto

        val mensagem : Mensagem = getItem(position)

        if (idDoCliente != mensagem.id){
        linha.setBackgroundColor(Color.CYAN)
        }

        texto.text = mensagem.texto

        return linha
    }

    override fun getItem(position: Int): Mensagem {
        return listaMensagens[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listaMensagens.size
    }
}