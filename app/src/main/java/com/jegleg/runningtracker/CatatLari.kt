package com.jegleg.runningtracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class Catatlari : Fragment(R.layout.fragment_catatlari) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi View berdasarkan ID di fragment_catatlari.xml
        val etTanggal = view.findViewById<EditText>(R.id.etTanggal)
        val etJarak = view.findViewById<EditText>(R.id.etJarak)
        val etDurasi = view.findViewById<EditText>(R.id.etDurasi)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val tanggal = etTanggal.text.toString()
            val jarakInput = etJarak.text.toString()
            val durasi = etDurasi.text.toString()

            // 1. Validasi Input
            if (tanggal.isEmpty() || jarakInput.isEmpty() || durasi.isEmpty()) {
                Toast.makeText(requireContext(), "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2. Tampung ke dalam Data Class
            // Jarak dikonversi ke Double, Durasi tetap String (atau bisa Int jika perlu)
            val dataLari = RunModel(
                tanggal = tanggal,
                jarak = jarakInput.toDoubleOrNull() ?: 0.0,
                durasi = durasi
            )

            // 3. Logika setelah data ditampung (Contoh: Tampilkan Toast)
            Toast.makeText(
                requireContext(),
                "Data Berhasil Ditampung: ${dataLari.jarak} KM",
                Toast.LENGTH_SHORT
            ).show()

            // Bersihkan form
            etTanggal.text.clear()
            etJarak.text.clear()
            etDurasi.text.clear()

            // Go back to Profile or Previous screen after savin
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProfileFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}

data class RunModel(
    val tanggal: String,
    val jarak: Double,
    val durasi: String
)
