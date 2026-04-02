package com.jegleg.runningtracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEdit = view.findViewById<Button>(R.id.btnEdit)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val btnCatat = view.findViewById<Button>(R.id.btnCatat)

        btnEdit.setOnClickListener {
            Toast.makeText(requireContext(), "Edit Profile clicked", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegisterFragment())
                .commit()
        }

        btnCatat.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Catatlari())
                .addToBackStack(null)
                .commit()
        }
    }
}