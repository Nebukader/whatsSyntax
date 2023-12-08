package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.data.ui.ChatFragmentDirections
import com.syntax_institut.whatssyntax.databinding.ListItemBinding

class ChatAdapter(
    private val dataset: List<Chat>
) : RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    /**
     * hier werden neue ViewHolder erstellt
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        holder.binding.nameTV.text = item.contact.name
        holder.binding.avatarIV.setImageResource(item.contact.image)

        holder.binding.lastMessageTV.text = item.messages.last().text

        holder.binding.ChatCV.setOnClickListener{
            holder.itemView.findNavController().navigate(ChatFragmentDirections.actionChatFragmentToChatDetailFragment(position))
        }
    }
    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

}