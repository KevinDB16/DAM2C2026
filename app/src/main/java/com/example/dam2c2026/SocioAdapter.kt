package com.example.dam2c2026

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class SocioAdapter(private val socios: List<Socio>,
                   private val dbHelper: SocioDBHelper,
                   private val actualizarLista: () -> Unit) : RecyclerView.Adapter<SocioAdapter.SocioViewHolder>() {

    class SocioViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val txtNombre: TextView = itemView.findViewById(R.id.txtItemNombre)

        val txtDni: TextView = itemView.findViewById(R.id.txtItemDni)

        val txtEmail: TextView = itemView.findViewById(R.id.txtItemEmail)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SocioViewHolder {

        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_socio, parent, false)

        return SocioViewHolder(vista)
    }

    override fun onBindViewHolder(
        holder: SocioViewHolder,
        position: Int
    ) {
        val socio = socios[position]

        holder.txtNombre.text = socio.nombre
        holder.txtDni.text = "DNI: ${socio.dni}"
        holder.txtEmail.text = "Email: ${socio.email}"

        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Eliminar socio")
                .setMessage("¿Querés eliminar a ${socio.nombre}")
                .setNegativeButton("Cancelar", null)
                .setPositiveButton("Eliminar") {_,_ ->
                    val resultado = dbHelper.eliminarSocio(socio.id)
                    if(resultado > 0){
                        Toast.makeText(holder.itemView.context, "Socio eliminado correctamente", Toast.LENGTH_LONG).show()
                        actualizarLista()
                    }
                }
                .show()
            true
        }
    }

    override fun getItemCount(): Int {
        return socios.size
    }
}
