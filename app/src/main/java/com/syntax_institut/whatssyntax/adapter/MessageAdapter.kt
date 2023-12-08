package com.syntax_institut.whatssyntax.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.databinding.MessageBubbleBinding

class MessageAdapter (
    private val messages: List<Message>,
): RecyclerView.Adapter<MessageAdapter.ItemViewHolder>() {
    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(val binding: MessageBubbleBinding) :
        RecyclerView.ViewHolder(binding.root)
    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = MessageBubbleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }
    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val message = messages[position]
        holder.binding.messageChatTV.text = message.text

        if (message.incoming) {
            holder.binding.messageLayoutLL.gravity = Gravity.START

        } else {
            holder.binding.messageLayoutLL.gravity = Gravity.END
            holder.binding.messageChatTV.setBackgroundResource(R.drawable.message_out)
        }
    }
    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return messages.size
    }
}