package com.example.puutuumommy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.puutuumommy.R
import com.example.puutuumommy.model.CatalogItem
import com.example.puutuumommy.ui.CatalogFragment

class CatalogItemAdapter(private val context: CatalogFragment, private val catalogItemSet: List<CatalogItem>):
    RecyclerView.Adapter<CatalogItemAdapter.CatalogItemViewHolder>() {


    class CatalogItemViewHolder(val view : View) : RecyclerView.ViewHolder(view){
            val imageView : ImageView = view.findViewById(R.id.catalog_image)
            val textView  : TextView = view.findViewById(R.id.catalog_text)
            val cardView : CardView = view.findViewById(R.id.catalog_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.catalog_item,parent,false)
        return CatalogItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
        val data = catalogItemSet[position]
        holder.imageView.setImageResource(data.imageResourceId)
        holder.textView.text = context.resources.getString(data.nameResoruceId)
        holder.cardView.setOnClickListener {
            context.sharedViewModel.setItemType(context.resources.getString(data.nameResoruceId))
            context.goToSelectedItemScreen()
        }


    }


    override fun getItemCount() = catalogItemSet.size
}