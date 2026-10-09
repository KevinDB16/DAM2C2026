package com.example.dam2c2026

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cardInscribirSocio = findViewById<LinearLayout>(R.id.cardInscribirSocio)

        cardInscribirSocio.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Inscribir nuevo socio")
                .setMessage("¿Desea comenzar la inscripción?")
                .setPositiveButton("Continuar"){_, _, ->
                    Toast.makeText(this, "Redirigiendo a la pantalla de inscripción", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, AltaSocioActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }
}