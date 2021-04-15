package com.example.continuada2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

lateinit var etTipo1:EditText
lateinit var etTipo2:EditText
lateinit var apiCachorrro:ApiCachorrro


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val layout:LinearLayout = findViewById(R.id.layout_lista)
        apiCachorrro = ConexaoApiCachorros.criar()


//        apiCachorrro.get().enqueue(object : retrofit2.Callback<List<Cachorro>> {
//            override  fun onResponse(
//                call: Call<List<Cachorro>>,
//                response: Response<List<Cachorro>>
//            ) {
//                response.body()?.forEach() {
//                    val tvCachorro = TextView(baseContext)
//                    tvCachorro.text =
//                        "Id: ${it.id} - Raça: ${it.raca} - Preço Médio: ${it.precoMedio} - Indicado para Criaças: ${it.indicadoCriancas}"
//                    layout.addView(tvCachorro)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Cachorro>>, t: Throwable) {
//                Log.e("api", t.message!!)
//                Toast.makeText(baseContext, "t.message", Toast.LENGTH_SHORT).show()
//            }
//        })
    }

    fun comprar(view: View) {


        etTipo1 = findViewById(R.id.et_tipo1)
        etTipo2 = findViewById(R.id.et_tipo2)
        val id1 = etTipo1.text.toString().toInt()
        val id2 = etTipo2.text.toString().toInt()

        apiCachorrro.get(id1).enqueue(object : retrofit2.Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 404) {
                    Toast.makeText(baseContext, "Id 1 não encontrado", Toast.LENGTH_SHORT).show()
                    etTipo1.text = null
                }
            }
            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })

        apiCachorrro.get(id2).enqueue(object : retrofit2.Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 404) {
                    Toast.makeText(baseContext, "Id 2 não encontrado", Toast.LENGTH_SHORT).show()
                    etTipo2.text = null
                }
            }
            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })


        if(etTipo1 == null && etTipo2 == null){
            val tela2 = Intent(this, Tela2::class.java)
            tela2.putExtra("id1", id1)
            tela2.putExtra("id2", id2)
            startActivity(tela2)
        }
    }
}