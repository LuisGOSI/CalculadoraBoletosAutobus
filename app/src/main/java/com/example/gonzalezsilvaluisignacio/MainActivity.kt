package com.example.gonzalezsilvaluisignacio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvPregunta: TextView
    private lateinit var numBole: EditText
    private lateinit var tvCiudad: TextView
    private lateinit var rgBoletos: RadioGroup
    private lateinit var rbCDMX: RadioButton
    private lateinit var rbQRO: RadioButton
    private lateinit var rbTequis: RadioButton
    private lateinit var tvLunch: TextView
    private lateinit var chkLunch: CheckBox
    private lateinit var btnCalcular: Button
    private lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPregunta = findViewById(R.id.tvPregunta)
        numBole = findViewById(R.id.numBole)
        rgBoletos = findViewById(R.id.rgBoletos)
        tvCiudad = findViewById(R.id.tvCiudad)
        rbCDMX = findViewById(R.id.rbCDMX)
        rbQRO = findViewById(R.id.rbQRO)
        rbTequis = findViewById(R.id.rbTequis)
        tvLunch = findViewById(R.id.tvLunch)
        chkLunch = findViewById(R.id.chkLunch)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvTotal = findViewById(R.id.tvTotal)

        btnCalcular.setOnClickListener {
            val boletosText = numBole.text.toString()
            if (boletosText.isEmpty()) {
                tvTotal.text = "Debes escribir un número de boletos"
            } else if (boletosText.toIntOrNull() == null) {
                tvTotal.text = "El valor ingresado no es un número válido"
            } else {
                val boletos = boletosText.toInt()
                var total = 0

                if (rbCDMX.isChecked) {
                    total = boletos * 450
                } else if (rbQRO.isChecked) {
                    total = boletos * 80
                } else if (rbTequis.isChecked) {
                    total = boletos * 45
                } else {
                    tvTotal.text = "No se seleccionó destino de viaje"
                    return@setOnClickListener
                }

                if (chkLunch.isChecked) {
                    total += boletos * 20
                }

                tvTotal.text = "Su total es: $total"
            }
        }
    }
}
