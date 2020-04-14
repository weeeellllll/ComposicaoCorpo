package com.well.composiocorporal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.log10
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_masculino.*



class MasculinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masculino)

        val nome = intent.getStringExtra("nome")


        textView7.text= "Seja bem-vindo $nome"


        buttonCalcDC.setOnClickListener(View.OnClickListener {
            resultadoDC()

        })
    }

    fun resultadoDC(){
        val soma = editAB.text.toString().toDouble()+editSI.text.toString().toDouble()+editTR.text.toString().toDouble()
        val resultado: Double = 1.17136-0.06706 * log10(soma)
        val peso = intent.getDoubleExtra("peso",0.0)
        val intent = Intent(this,ResultadoMascActivity::class.java )
        intent.putExtra("DC", resultado)
        intent.putExtra("peso", peso)
        startActivity(intent)

    }

}
