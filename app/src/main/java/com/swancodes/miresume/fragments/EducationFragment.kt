package com.swancodes.miresume.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.miresume.adapter.EducationAdapter
import com.swancodes.miresume.data.EducationData
import com.swancodes.miresume.databinding.FragmentEducationBinding

class EducationFragment : Fragment() {

    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView

        val myDataSet = EducationData().getEducationData()
        recyclerView.adapter = EducationAdapter(requireContext(), myDataSet)
        recyclerView.setHasFixedSize(true)
        
        binding.constraintLayout.setOnClickListener { 
            goToUrl("https://drive.google.com/file/d/1c5E2Q_ihDSbRxTq0K4hBVJKwcPluY4zc/view")
        }
        binding.constraintLayout2.setOnClickListener {
            goToUrl("https://drive.google.com/file/d/1Kylco5beitiZtXGkaPCBHov_z_Uei7Q7/view")
        }
    }

    private fun goToUrl(link: String) {
        val uri = Uri.parse(link)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}