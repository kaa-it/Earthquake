package com.example.earthquake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EarthquakeRecyclerViewAdapter(val earthquakes: List<Earthquake>): RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EarthquakeRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_earthquake, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EarthquakeRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.earthquake = earthquakes[position]
        holder.detailsView.text = earthquakes[position].toString()
    }

    override fun getItemCount(): Int {
        return earthquakes.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val parentView = view
        val detailsView: TextView
        lateinit var earthquake: Earthquake

        init {
            detailsView = view.findViewById(R.id.list_item_earthquake_details) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + detailsView.text + "'"
        }
    }
}