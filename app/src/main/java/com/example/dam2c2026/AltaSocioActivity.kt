package com.example.dam2c2026

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AltaSocioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta_socio)

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtDni = findViewById<EditText>(R.id.txtDni)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val btnGuardarSocio = findViewById<Button>(R.id.btnGuardarSocio)

        btnGuardarSocio.setOnClickListener {
            val nombre = txtNombre.text.toString().trim()
            val dni = txtDni.text.toString().trim()
            val email = txtEmail.text.toString().trim()

            if(nombre.isEmpty() || dni.isEmpty() || email.isEmpty()){
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            } else if(!(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                Toast.makeText(this, "Ingrese un mail válido", Toast.LENGTH_SHORT).show()
            } else{
                val socio = Socio(nombre = nombre, dni = dni, email = email)
                Datos.socios.add(socio)
                Log.d("SOCIO", socio.toString())

                finish()
            }

        }


    }
}