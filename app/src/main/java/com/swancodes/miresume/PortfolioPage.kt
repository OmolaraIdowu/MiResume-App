package com.swancodes.miresume

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.miresume.adapter.PortfolioAdapter
import com.swancodes.miresume.data.PortfolioData
import com.swancodes.miresume.databinding.ActivityPortfolioPageBinding
import com.swancodes.miresume.util.navigate

class PortfolioPage : AppCompatActivity() {

    private lateinit var binding: ActivityPortfolioPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortfolioPageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val myDataSet = PortfolioData().getPortfolioData()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = PortfolioAdapter(this, myDataSet)
        recyclerView.setHasFixedSize(true)

        binding.portfolioArrow.setOnClickListener {
            navigate(HomePage::class.java)
        }
    }
    override fun onBackPressed() {
    }
}