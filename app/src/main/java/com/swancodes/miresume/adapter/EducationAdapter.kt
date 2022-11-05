package com.swancodes.miresume.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.miresume.R
import com.swancodes.miresume.model.Education

class EducationAdapter(private val context: Context, private val dataSet: List<Education>) :
    RecyclerView.Adapter<EducationAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.summaryText)
        val date: TextView = view.findViewById(R.id.date)
        val info: TextView = view.findViewById(R.id.info)
        val image: ImageView = view.findViewById(R.id.udemy)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.education_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.title.text = context.resources.getString(item.stringResourceId)
        holder.date.text = context.resources.getString(item.stringResourceId2)
        holder.info.text = context.resources.getString(item.stringResourceId3)
        holder.image.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataSet.size
}