package com.example.dam2c2026

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SocioAdapter(private val socios: List<Socio>) : RecyclerView.Adapter<SocioAdapter.SocioViewHolder>() {

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
    }

    override fun getItemCount(): Int {
        return socios.size
    }
}
