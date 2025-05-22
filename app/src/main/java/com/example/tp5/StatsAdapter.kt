package com.example.tp5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5.databinding.ItemStatBinding

class StatsAdapter(private val stats: List<DailyStat>) :
    RecyclerView.Adapter<StatsAdapter.StatViewHolder>() {

    inner class StatViewHolder(val binding: ItemStatBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatViewHolder {
        val binding = ItemStatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        val stat = stats[position]
        holder.binding.textJour.text = stat.jour
        holder.binding.textPresents.text = "Présents: ${stat.presents}"
        holder.binding.textAbsents.text = "Absents: ${stat.absents}"
    }

    override fun getItemCount() = stats.size
}
