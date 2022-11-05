package com.swancodes.miresume.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.miresume.R
import com.swancodes.miresume.model.Portfolio

class PortfolioAdapter(private val context: Context, private val dataSet: ArrayList<Portfolio>) :
    RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder>() {

    class PortfolioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.text)
        val image: ImageView = view.findViewById(R.id.udemy)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.portfolio_list_item, parent, false)
        return PortfolioViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val item = dataSet[position]
        holder.title.text = context.resources.getString(item.stringResourceId)
        holder.image.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataSet.size
}
