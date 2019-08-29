package com.kayosys.demo.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kayosys.demo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.currency_item.view.*

class CurrencyAdapter (val context: Context, val currencyName:ArrayList<String>, val price:ArrayList<String>,val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(currencyName:String,price:String);
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.currency_item,p0,false))
    }

    override fun getItemCount(): Int {
        return currencyName.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        var url="https://www.countryflags.io/dummy/shiny/64.png"
        viewHolder.currencyName.text=currencyName.get(p1)
        viewHolder.priceTv.text=price.get(p1)
        if (currencyName.get(p1).length>2){
            Picasso.get().load(url.replace("dummy",currencyName.get(p1).substring(0,2).toLowerCase())).into(viewHolder.flags);
        }
         viewHolder.view.currencyName.setOnClickListener {
            onItemClickListener.onItemClick(currencyName.get(p1),price.get(p1))
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val currencyName = view.currencyName
        val flags = view.flags
        val priceTv = view.priceTv
        val view=view
    }
}