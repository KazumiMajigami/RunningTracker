package com.jegleg.runningtracker

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Spinner Gender
        val spinner = view.findViewById<Spinner>(R.id.spGender)
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gender_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Views
        val etName = view.findViewById<EditText>(R.id.etName)
        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val gender = spinner.selectedItem.toString()

            // Validasi form
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Buat Object User (agar tidak warning lagi)
            val user = User(
                name = name,
                gender = gender,
                email = email,
                password = password
            )

            // Pesan sukses
            val message = """
                Registrasi Berhasil!
                
                Nama: ${user.name}
                Email: ${user.email}
                Gender: ${user.gender}
            """.trimIndent()

            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        }
    }
}