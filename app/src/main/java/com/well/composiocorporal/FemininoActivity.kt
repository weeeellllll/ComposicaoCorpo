package com.well.composiocorporal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_feminino.*
import kotlin.math.log10

class FemininoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feminino)
        val nome = intent.getStringExtra("nome")


        textViewFem.text= "Seja bem-vindo $nome"


        buttonCalcDCFem.setOnClickListener(View.OnClickListener {
            resultadoDC()

        })
    }
    fun resultadoDC(){
        val soma = editCX.text.toString().toDouble()+editSIfem.text.toString().toDouble()+editSB.text.toString().toDouble()
        val resultado: Double = 1.16650- 0.07063 * log10(soma)
        val peso = intent.getDoubleExtra("peso",0.0)
        val intent = Intent(this,ResultadoFemActivity::class.java )
        intent.putExtra("DC", resultado)
        intent.putExtra("peso", peso)
        startActivity(intent)

    }
}
