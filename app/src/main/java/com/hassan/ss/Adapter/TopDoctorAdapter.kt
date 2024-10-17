package com.hassan.ss.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.hassan.ss.Activity.detailActivity
import com.hassan.ss.Domain.DoctorModel
import com.hassan.ss.databinding.ViewholderTopDoctorBinding

class TopDoctorAdapter(val items:MutableList<DoctorModel>)

    :RecyclerView.Adapter<TopDoctorAdapter.viewholder>() {

private lateinit var  context :Context

    class viewholder(val  binding: ViewholderTopDoctorBinding)
        :RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDoctorAdapter.viewholder {
       context=parent.context
        val binding=ViewholderTopDoctorBinding.inflate(LayoutInflater.from(context),parent,false)
        return viewholder(binding)
    }

    override fun onBindViewHolder(holder: TopDoctorAdapter.viewholder, position: Int) {
        holder.binding.nameText.text=items[position].Name
        holder.binding.specialText.text=items[position].Special
        holder.binding.ratingText.text=items[position].Rating.toString()
        holder.binding.yearText.text=items[position].Expriense.toString()+ "year"
        Glide.with(holder.itemView.context).load(items[position].Picture).apply{
            RequestOptions().transform(CenterCrop()) }.into(
                holder.binding.imgb
            )

        holder.itemView.setOnClickListener {
            val intent =Intent(context,detailActivity::class.java)
            intent.putExtra("object",items[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}