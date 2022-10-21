package com.rifqipadisiliwangi.latihan_mvvm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rifqipadisiliwangi.latihan_mvp.model.DataCarItem
import com.rifqipadisiliwangi.latihan_mvvm.databinding.ItemCarBinding

class CarAdapter (var listCar : List<DataCarItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val id = listCar[position].id.toString()
        val nama = listCar[position].name
        val cat = listCar[position].category
        val price = listCar[position].price.toString()
        val img = listCar[position].image

        holder.binding.tvIdCar.text = id
        holder.binding.tvNameUser.text = nama
        holder.binding.tvCategory.text = cat
        holder.binding.tvPrice.text = "Rp."+ price
        Glide.with(holder.itemView).load(img).into(holder.binding.carImage)


    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}