package com.uvg.rvtallerdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*
import java.lang.Exception

// El comentario de adentro era una prueba
/*var items: MutableList<String>*/
class Adaptador(private val clickListener: (Int) -> Unit, private val longClickListener: (Int) -> Unit) : RecyclerView.Adapter<Adaptador.ItemsViewHolder>() {
    // Metodos heredados de adaptador
    // Lista de los elementos que se mostraran
    private var items: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, clickListener, longClickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(nuevosItems: MutableList<String>){
        this.items = nuevosItems
        notifyDataSetChanged()
    }

    fun getItem(position: Int):String{
        return items[position]
    }



    fun removeItem(position: Int){
        items.removeAt(position)
        setItems(items)
    }

    fun modifyItem(position: Int){
        items[position] = "Modificado UwU"
        setItems(items)
    }

    //clase
    class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item:String,  click: (Int) -> Unit, longClickListener: (Int) -> Unit) = with(itemView){
            txtTitulo.text = item

            setOnClickListener{
                click(adapterPosition)
            }

            setOnLongClickListener {
                longClickListener(adapterPosition)
                true
            }
        }
    }

}