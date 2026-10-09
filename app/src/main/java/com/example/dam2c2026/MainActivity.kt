package com.example.dam2c2026


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtUsuario = findViewById<EditText>(R.id.txtUsuario)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)

        btnIniciarSesion.setOnClickListener {

            val usuario = txtUsuario.text.toString()
            val password = txtPassword.text.toString()

            if (usuario.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_LONG).show()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}