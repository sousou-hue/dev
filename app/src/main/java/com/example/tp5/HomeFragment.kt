package com.example.tp5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var statsAdapter: StatsAdapter
    private val dailyStats = listOf(
        DailyStat("Lundi", 15, 3),
        DailyStat("Mardi", 17, 1),
        DailyStat("Mercredi", 16, 2),
        DailyStat("Jeudi", 18, 0),
        DailyStat("Vendredi", 14, 4)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        statsAdapter = StatsAdapter(dailyStats)
        binding.recyclerViewStats.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = statsAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
