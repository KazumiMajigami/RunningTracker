package com.jegleg.runningtracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_beranda) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEdit = view.findViewById<Button>(R.id.btnEdit)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val btnCatat = view.findViewById<Button>(R.id.btnCatat)

        // EDIT → ga kemana-mana
        btnEdit.setOnClickListener {
            android.widget.Toast.makeText(requireContext(), "Edit Profile clicked", android.widget.Toast.LENGTH_SHORT).show()
        }

        // LOGOUT → balik ke RegisterFragment
        btnLogout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegisterFragment())
                .commit()
        }

        // CATAT LARI → sementara cuma toast
        btnCatat.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Catatlari())
                .addToBackStack(null)
                .commit()
        }
    }
}