package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.adapter.CallAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.CallScreenBinding


class CallListFragment: Fragment() {
    private lateinit var binding: CallScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = CallScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Log-Ausgabe zum Überprüfen, ob onViewCreated aufgerufen wurde
        Log.d("Tag", "onViewCreated")

        // Daten abrufen
        val datasetCall = Datasource().getCalls()

        // Log-Ausgabe zum Überprüfen, ob Daten abgerufen wurden
        Log.d("ListFragment", "Dataset size: ${datasetCall.size}")

        val dataset = Datasource().getCalls()
        val callAdapter = CallAdapter(requireActivity(), dataset)
        binding.callListRV.adapter = callAdapter


        // Log-Ausgabe zum Überprüfen, ob Adapter gesetzt wurde
        Log.d("ListFragment", "Adapter set successfully")
    }
}
