package com.example.continuada2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        val id1 = intent.getIntExtra("id1")
        val id2 = intent.getIntExtra("id2")


        var mensagem = getString(R.string.tela2, id1, id2)

        val tvTela2:TextView = findViewById(R.id.tv_tela2)
        tvTela2.text = mensagem
    }
}