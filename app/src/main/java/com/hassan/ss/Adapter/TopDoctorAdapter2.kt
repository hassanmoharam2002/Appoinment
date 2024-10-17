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
import com.hassan.ss.databinding.ViewholderTopDoctor2Binding
import com.hassan.ss.databinding.ViewholderTopDoctorBinding

class TopDoctorAdapter2(val items:MutableList<DoctorModel>)

    :RecyclerView.Adapter<TopDoctorAdapter2.viewholder>() {

private lateinit var  context :Context

    class viewholder(val  binding: ViewholderTopDoctor2Binding)
        :RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDoctorAdapter2.viewholder {
       context=parent.context
        val binding=ViewholderTopDoctor2Binding.inflate(LayoutInflater.from(context),parent,false)
        return viewholder(binding)
    }

    override fun onBindViewHolder(holder: TopDoctorAdapter2.viewholder, position: Int) {
        holder.binding.nameTxt.text=items[position].Name
        holder.binding.specialh.text=items[position].Special
        holder.binding.score.text=items[position].Rating.toString()
        holder.binding.ratingBar.rating=items[position].Rating.toFloat()
        holder.binding.degreetxt.text="professional Doctor"
        Glide.with(holder.itemView.context).load(items[position].Picture).apply{
            RequestOptions().transform(CenterCrop()) }.into(
                holder.binding.img
            )

        holder.binding.makeBtn.setOnClickListener {
            val intent =Intent(context,detailActivity::class.java)
            intent.putExtra("object",items[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}