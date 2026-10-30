package com.example.dam2c2026

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SocioDBHelper(context: Context): SQLiteOpenHelper(context, "Club.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE socios(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                dni TEXT NOT NULL,
                email TEXT NOT NULL
            )""".trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun agregarSocio(socio: Socio): Long {
        val db = writableDatabase

        val valores = ContentValues().apply {
            put("nombre", socio.nombre)
            put("dni", socio.dni)
            put("email", socio.email)
        }

        val resultado = db.insert("socios", null, valores)
        db.close()
        return resultado
    }

    fun obtenerSocios(): MutableList<Socio>{
        val lista = mutableListOf<Socio>()
        val db = readableDatabase

        val cursor = db.rawQuery("SELECT id, nombre, dni, email FROM socios ORDER BY id DESC", null)

        cursor.use{
            while(it.moveToNext()){
                lista.add(Socio(
                    id = it.getInt(0),
                    nombre = it.getString(1),
                    dni = it.getString(2),
                    email = it.getString(3)
                    )
                )
            }
            db.close()
            return lista
        }
    }

    fun eliminarSocio(id: Int): Int {
        val db = writableDatabase
        val resultado = db.delete("socios", "id = ?", arrayOf(id.toString()))
        db.close()
        return resultado
    }

}