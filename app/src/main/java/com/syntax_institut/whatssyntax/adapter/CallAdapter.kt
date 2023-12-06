package com.syntax_institut.whatssyntax.adapter
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.data.model.Call
import com.syntax_institut.whatssyntax.databinding.CallListItemBinding

class CallAdapter(
    private val activity: Activity,
    private val dataset: List<Call>,
) : RecyclerView.Adapter<CallAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(val binding: CallListItemBinding) : RecyclerView.ViewHolder(binding.root)

    /**
     * hier werden neue ViewHolder erstellt
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CallListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }
    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        dataset.sortedBy { item.time }


        holder.binding.nameCallTV.text = item.contact.name
        holder.binding.avatarCallIV.setImageResource(item.contact.image)
        holder.binding.lastCallTv.text = item.time

        holder.binding.callSignAcceptIV.visibility = if (item.accepted) View.VISIBLE else View.GONE
        holder.binding.missedCallSignIV.visibility = if (!item.accepted) View.VISIBLE else View.GONE

        holder.binding.cardCallCV.setOnClickListener{
            val callNumber = item.contact.number
            Log.d("CallNumber", callNumber)
            dialPhoneNumber(callNumber)

        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val packageManager = activity.packageManager
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            activity.startActivity(intent)
        }else{
            activity.startActivity(intent)
        }
    }

}
