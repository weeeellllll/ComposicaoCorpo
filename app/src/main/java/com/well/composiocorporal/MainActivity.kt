package com.well.composiocorporal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonMasc.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MasculinoActivity::class.java)
            intent.putExtra("nome", editNome.text.toString())
            intent.putExtra("idade", editIdade.text.toString())
            intent.putExtra("peso",editPeso.text.toString().toDouble())
            startActivity(intent)

        })
        buttonFemin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FemininoActivity::class.java)
            intent.putExtra("nome", editNome.text.toString())
            intent.putExtra("idade", editIdade.text.toString())
            intent.putExtra("peso",editPeso.text.toString().toDouble())
            startActivity(intent)

        })
    }




}


