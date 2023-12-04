package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.adapter.ItemAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.FragmentListBinding
import com.syntax_institut.whatssyntax.databinding.ListItemBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
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

        val adapter = ItemAdapter(datasetContact)
        binding.recyclerView.adapter = adapter

        // Log-Ausgabe zum Überprüfen, ob Adapter gesetzt wurde
        Log.d("ListFragment", "Adapter set successfully")
    }
}