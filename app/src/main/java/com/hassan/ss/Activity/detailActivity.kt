package com.hassan.ss.Activity

import android.content.Intent
import android.net.Uri

import android.os.Bundle
import com.bumptech.glide.Glide

import com.hassan.ss.Domain.DoctorModel

import com.hassan.ss.databinding.ActivityDetailBinding

class detailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item:DoctorModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getm()
    }

    private fun getm(){
        item=intent.getParcelableExtra("object")!!

        binding.apply {
            titletext.text=item.Name
            special.text=item.Special
            pationstext.text=item.Patiens
            biotext.text=item.Biography
            adress.text=item.Address
            biotext.text=item.Biography


            experincetext.text=item.Expriense.toString()+"years"
            ratingText.text=item.Rating.toString()
            backin.setOnClickListener { finish() }
            website.setOnClickListener {
                val i=Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(item.Site))
                startActivity(i)
            }
            message.setOnClickListener {
                val uri=Uri.parse("smsto:${item.Mobile}")
                val intent=Intent(Intent.ACTION_SENDTO,uri)
                intent.putExtra("sms_body","the SMS text")
                startActivity(intent)

            }
            call.setOnClickListener {
                val uri="tel:"+item.Mobile.trim()
                val intent=Intent(Intent.ACTION_CALL,Uri.parse(uri))
                startActivity(intent)

            }
            direction.setOnClickListener {
                val intent=Intent(Intent.ACTION_VIEW,Uri.parse(item.Location))
                startActivity(intent)
            }
            share.setOnClickListener {
                val intent =Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT,item.Name)
                intent.putExtra(Intent.EXTRA_TEXT,item.Name+""+item.Address+""+item.Mobile )
                startActivity(Intent.createChooser(intent,"choose one"))
            }
            Glide.with(this@detailActivity)
                .load(item.Picture)
                .into(imgh)




        }
    }



}