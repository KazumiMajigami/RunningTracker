package com.jegleg.runningtracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class RunEntryFragment : Fragment(R.layout.fragment_catatlari) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etTanggal = view.findViewById<EditText>(R.id.etTanggal)
        val etJarak = view.findViewById<EditText>(R.id.etJarak)
        val etDurasi = view.findViewById<EditText>(R.id.etDurasi)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {

            val tanggal = etTanggal.text.toString()
            val jarak = etJarak.text.toString()
            val durasi = etDurasi.text.toString()

            if (tanggal.isEmpty() || jarak.isEmpty() || durasi.isEmpty()) {
                Toast.makeText(requireContext(), "Isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // nanti bisa disimpan ke database

            Toast.makeText(requireContext(), "Data berhasil disimpan ✅", Toast.LENGTH_SHORT).show()
        }
    }
}