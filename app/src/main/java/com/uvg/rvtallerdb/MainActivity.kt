package com.uvg.rvtallerdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    private val adapter = Adaptador({
        clickListener -> showItemClick(clickListener)
    },{
        longClickListener -> modifyFunction(longClickListener)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("UwU")
        items.add("Owo")

        adapter.setItems(items)

        //Lista del xml
        //Existen diferentes tipos de layout
        Lista.layoutManager = LinearLayoutManager(this)
        Lista.adapter = adapter

        insertBtn.setOnClickListener(){
            items.add("Nuevo")
            adapter.setItems(items)
        }

    }

    //Metodo para modificar elementos
    fun showItemClick(position:Int){
        adapter.removeItem(position)
    }

    fun modifyFunction(position: Int){
        adapter.modifyItem(position)
    }
}