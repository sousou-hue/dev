package com.example.tp5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoriqueAdapter(private val items: List<Historique>) : RecyclerView.Adapter<HistoriqueAdapter.HistoViewHolder>() {

    class HistoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.titleText)
        val descriptionText: TextView = view.findViewById(R.id.descriptionText)
        val dateText: TextView = view.findViewById(R.id.dateText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historique, parent, false)
        return HistoViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoViewHolder, position: Int) {
        val item = items[position]
        holder.titleText.text = item.title
        holder.descriptionText.text = item.description
        holder.dateText.text = item.date
    }

    override fun getItemCount(): Int {
        return items.size
    }
}