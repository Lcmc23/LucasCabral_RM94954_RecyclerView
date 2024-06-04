package lcmc23.com.lucascabral_rm94954_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lcmc23.com.lucascabral_rm94954_recyclerview.R
import lcmc23.com.lucascabral_rm94954_recyclerview.model.ItemModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName = view.findViewById<TextView>(R.id.textViewItem)
        val textViewCity = view.findViewById<TextView>(R.id.textViewCity)
        val textViewState = view.findViewById<TextView>(R.id.textViewState)

        fun bind(item: ItemModel) {
            textViewName.text = "\nPraia: ${item.name}"
            textViewCity.text = "\nCidade: ${item.city}"
            textViewState.text = "\nEstado: ${item.state}"
        }
    }
}
