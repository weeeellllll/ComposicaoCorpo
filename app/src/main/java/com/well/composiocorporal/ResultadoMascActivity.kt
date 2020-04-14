package com.well.composiocorporal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_masc.*

class ResultadoMascActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_masc)
        getClassificacaoMale()



    }
    fun getClassificacaoMale() {

        //Classificação
        val resultado = intent.getDoubleExtra("DC", 0.0)
        val classificacao = ((4.95 / resultado) - 4.50) * 100
        if (classificacao <= 4.99) {
            textClassificacao.text = "Magro"
        } else if (classificacao in 5.0..8.99) {
            textClassificacao.text = "Abaixo da média"
        } else if (classificacao in 9.0..16.99) {
            textClassificacao.text = "Na média"
        } else if (classificacao in 17.0..24.99) {
            textClassificacao.text = "Acima da média"
        } else if (classificacao >= 25) {
            textClassificacao.text = "Obeso"
        } else {
            textClassificacao.text = "Inválido"
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
