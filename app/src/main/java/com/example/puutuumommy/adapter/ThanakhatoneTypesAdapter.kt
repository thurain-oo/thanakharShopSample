package com.example.puutuumommy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.puutuumommy.R
import com.example.puutuumommy.model.ThanakhatoneItem
import com.example.puutuumommy.ui.ThanakhatoneFragment


class ThanakhatoneTypesAdapter(val context : ThanakhatoneFragment, val dataset : List<ThanakhatoneItem>) :
    RecyclerView.Adapter<ThanakhatoneTypesAdapter.ThanakhatoneTypesViewHolder>() {

    class ThanakhatoneTypesViewHolder(val view : View) : RecyclerView.ViewHolder(view ){
        val imageView : ImageView = view.findViewById(R.id.thanakhatone_image)
        val properties : TextView = view.findViewById(R.id.properties_of_thanakhatone)
        val price : TextView = view.findViewById(R.id.price_of_thanakhatone)
        val wholeCard : CardView = view.findViewById(R.id.thanakhatone_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThanakhatoneTypesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.thanakatone_adapter_item,parent,false)
            return  ThanakhatoneTypesViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ThanakhatoneTypesAdapter.ThanakhatoneTypesViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.properties.text = context.resources.getString(item.property)
        holder.price.text = context.resources.getString(item.price)
        holder.wholeCard.setOnClickListener{
            context.orderThanakha(context.resources.getString(item.price).toInt())
        }
    }

    override fun getItemCount(): Int = dataset.size

}