package com.swancodes.miresume.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.miresume.adapter.ExperienceAdapter
import com.swancodes.miresume.data.ExperienceData
import com.swancodes.miresume.databinding.FragmentExperienceBinding


class ExperienceFragment : Fragment() {

    private var _binding: FragmentExperienceBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExperienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView

        val myDataSet = ExperienceData().getExperienceData()
        recyclerView.adapter = ExperienceAdapter(requireContext(), myDataSet)
        recyclerView.setHasFixedSize(true)
    }
}