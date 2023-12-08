package com.syntax_institut.whatssyntax.data.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.syntax_institut.whatssyntax.adapter.MessageAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.FragmentChatDetailBinding

class ChatDetailFragment : Fragment() {
    val args: ChatDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentChatDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chatList = Datasource().getChats()
        val chat = chatList[args.position]
        binding.chatHistoryRV.adapter = MessageAdapter(chat.messages)
        val chatImage = chat.contact.image
        binding.chatTargteIV.setImageResource(chatImage)
        binding.textView3.text = chat.contact.name
        binding.imageButton.setOnClickListener {
            findNavController().navigate(ChatDetailFragmentDirections.actionChatDetailFragmentToChatFragment())
        }

        Log.d("chatMessage", chat.toString())



    }
}