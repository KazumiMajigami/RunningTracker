package com.jegleg.runningtracker

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WelcomeFragment : Fragment(R.layout.fragment_beranda) {

    private var currentPage = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val page1 = view.findViewById<LinearLayout>(R.id.page1)
        val page2 = view.findViewById<LinearLayout>(R.id.page2)
        val fab = view.findViewById<FloatingActionButton>(R.id.fabNext)

        fab.setOnClickListener {
            if (currentPage == 1) {
                Log.d("WelcomeFragment", "Pindah ke page2")
                page1.visibility = View.GONE
                page2.visibility = View.VISIBLE
                currentPage = 2
            } else {
                Log.d("WelcomeFragment", "Mencoba buka RegisterFragment")
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, RegisterFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}