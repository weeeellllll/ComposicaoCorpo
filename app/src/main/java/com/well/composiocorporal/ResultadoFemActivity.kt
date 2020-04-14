package com.well.composiocorporal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_fem.*

class ResultadoFemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_fem)
        getClassificacaoFem()
    }
    fun getClassificacaoFem() {

        //Classificação
        val resultado = intent.getDoubleExtra("DC", 0.0)
        val classificacao = ((4.95 / resultado) - 4.50) * 100
        if (classificacao <= 8.99) {
            textClassificacaoFem.text = "Magro"
        } else if (classificacao in 9.0..14.99) {
            textClassificacaoFem.text = "Abaixo da média"
        } else if (classificacao in 15.0..22.99) {
            textClassificacaoFem.text = "Na média"
        } else if (classificacao in 23.0..29.99) {
            textClassificacaoFem.text = "Acima da média"
        } else if (classificacao >= 30) {
            textClassificacaoFem.text = "Obeso"
        } else {
            textClassificacaoFem.text = "Inválido"
        }
        //Peso gordo
        val peso= intent.getDoubleExtra("peso",0.0)
        val pesoGordo = (classificacao/100)*peso
        textpesogordo.text = "%.2f kg".format(pesoGordo)
        //Massa Magra
        val massaMagra = peso-pesoGordo
        textmassamagra.text="%.2f kg".format(massaMagra)
        //Peso ideal
        val pesoIdeal = massaMagra/0.85
        textpesoideal.text = "%.2f kg".format(pesoIdeal)
        //Peso em excesso
        val pesoExcesso = peso - pesoIdeal
        textpesoexcesso.text = "%.2f kg".format(pesoExcesso)




    }
}
