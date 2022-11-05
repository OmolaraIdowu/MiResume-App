package com.swancodes.miresume.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swancodes.miresume.R
import com.swancodes.miresume.databinding.FragmentAboutMeBinding

class AboutMeFragment : Fragment() {

    private var _binding: FragmentAboutMeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAboutMeBinding.inflate(inflater, container, false)

        return binding.root
    }
}