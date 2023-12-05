package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.adapter.ItemAdapter
import com.syntax_institut.whatssyntax.adapter.StatusAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.FragmentListBinding
import com.syntax_institut.whatssyntax.databinding.FragmentStatusBinding

class StatusFragment : Fragment() {

    private lateinit var binding: FragmentStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Log-Ausgabe zum Überprüfen, ob onViewCreated aufgerufen wurde
        Log.d("Tag", "onViewCreated")

        val navController = findNavController()

        // Daten abrufen
        val datasetContact = Datasource().getContacts()

        // Log-Ausgabe zum Überprüfen, ob Daten abgerufen wurden
        Log.d("ListFragment", "Dataset size: ${datasetContact.size}")

        val adapter = StatusAdapter(datasetContact)
        binding.StatusRV.adapter = adapter



        // Log-Ausgabe zum Überprüfen, ob Adapter gesetzt wurde
        Log.d("ListFragment", "Adapter set successfully")
    }
}