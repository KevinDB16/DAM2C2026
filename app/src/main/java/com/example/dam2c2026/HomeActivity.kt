package com.example.dam2c2026

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {

    private lateinit var rvSocios: RecyclerView
    private lateinit var txtSinSocios: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cardInscribirSocio = findViewById<LinearLayout>(R.id.cardInscribirSocio)

        rvSocios = findViewById(R.id.rvSocios)
        txtSinSocios = findViewById(R.id.txtSinSocios)

        rvSocios.layoutManager = LinearLayoutManager(this)
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

    override fun onResume(){
        super.onResume()
        cargarSocios()
    }

    private fun cargarSocios(){
        val socios = Datos.socios.toList()

        rvSocios.adapter = SocioAdapter(socios)

        if(socios.isEmpty()){
            txtSinSocios.visibility = View.VISIBLE
            rvSocios.visibility = View.GONE
        } else{
            txtSinSocios.visibility = View.GONE
            rvSocios.visibility = View.VISIBLE
        }
    }
}