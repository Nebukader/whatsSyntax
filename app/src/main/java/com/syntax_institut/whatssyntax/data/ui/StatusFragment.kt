package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.syntax_institut.whatssyntax.adapter.StatusAdapter
import com.syntax_institut.whatssyntax.data.Datasource
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


        val navController = findNavController()

        // Daten abrufen
        val datasetContact = Datasource().getContacts()
        val datasetContactFilter = datasetContact.filter {
            it.status!= null
        }

        val adapter = StatusAdapter(datasetContactFilter)
        //binding.StatusRV.adapter = adapter

        val recyclerView = binding.StatusRV
        recyclerView.adapter = adapter


    }
}