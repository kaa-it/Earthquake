package com.example.earthquake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT"
    }

    private lateinit var earthquakeListFragment: EarthquakeListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val ft = supportFragmentManager.beginTransaction()
            earthquakeListFragment = EarthquakeListFragment()
            ft.add(R.id.main_activity_frame, earthquakeListFragment, TAG_LIST_FRAGMENT)
            ft.commitNow()
        } else {
            earthquakeListFragment = supportFragmentManager.findFragmentByTag(TAG_LIST_FRAGMENT) as EarthquakeListFragment
        }

        val now = Calendar.getInstance().time
        val dummyQuakes = arrayListOf<Earthquake>()
        dummyQuakes.add(Earthquake("0", now, "San Jose", null, 7.3, null))
        dummyQuakes.add(Earthquake("1", now, "LA", null, 6.5, null))

        earthquakeListFragment.setEarthquakes(dummyQuakes)
    }
}
