package com.example.tp5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var historyAdapter: HistoriqueAdapter
    private lateinit var historyList: List<Historique>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHistoryBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerView

        // Fetch data from string arrays
        val titles = resources.getStringArray(R.array.historique_titles)
        val descriptions = resources.getStringArray(R.array.historique_description)
        val dates = resources.getStringArray(R.array.historique_dates)

        // Create a list of Historique objects
        historyList = titles.indices.map {
            Historique(titles[it], descriptions[it], dates[it])
        }

        // Set up RecyclerView with GridLayoutManager
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        historyAdapter = HistoriqueAdapter(historyList)
        recyclerView.adapter = historyAdapter

        return binding.root
    }
}