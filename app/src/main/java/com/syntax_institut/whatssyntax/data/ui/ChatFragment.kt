package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.syntax_institut.whatssyntax.adapter.ChatAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.FragmentListBinding

class ChatFragment : Fragment() {

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
        val datasetChat = Datasource().getChats()

        // Log-Ausgabe zum Überprüfen, ob Daten abgerufen wurden
        Log.d("ListFragment", "Dataset size: ${datasetChat.size}")



        val adapter = ChatAdapter(datasetChat)
        binding.recyclerView.adapter = adapter



    }
}