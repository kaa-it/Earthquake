package com.example.earthquake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_earthquake_list.*

class EarthquakeListFragment: Fragment() {
    private val earthquakes = arrayListOf<Earthquake>()
    private val earthquakeAdapter = EarthquakeRecyclerViewAdapter(earthquakes)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_earthquake_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(view.context)
        list.adapter = earthquakeAdapter
    }

    fun setEarthquakes(earthquakes: List<Earthquake>) : Unit {
        for (earthquake in earthquakes) {
            if (!this.earthquakes.contains(earthquake)) {
                this.earthquakes.add(earthquake)
                earthquakeAdapter.notifyItemInserted(this.earthquakes.indexOf(earthquake))
            }
        }
    }
}