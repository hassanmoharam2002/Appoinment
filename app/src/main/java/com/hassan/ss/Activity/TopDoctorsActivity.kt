package com.hassan.ss.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hassan.ss.Adapter.TopDoctorAdapter
import com.hassan.ss.Adapter.TopDoctorAdapter2

import com.hassan.ss.R
import com.hassan.ss.ViewModel.MainViewModel
import com.hassan.ss.databinding.ActivityTopDoctorsBinding


import com.hassan.ss.databinding.ViewholderTopDoctor2Binding

class TopDoctorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopDoctorsBinding
    private val viewmodel=MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTopDoctorsBinding. inflate(layoutInflater)

        setContentView(binding.root)
        initTopDoctors2()

        }

    private fun initTopDoctors2(){
        binding.apply {
            progresstopdoctor.visibility= View.VISIBLE
            viewmodel.doctors.observe(this@TopDoctorsActivity, Observer{

                viewtopdoctlist.layoutManager=
                    LinearLayoutManager(this@TopDoctorsActivity, LinearLayoutManager.VERTICAL,false)
                viewtopdoctlist.adapter= TopDoctorAdapter2(it)
                progresstopdoctor.visibility= View.GONE
            })
            viewmodel.loudDoctors()
            backbtn.setOnClickListener {
                finish()
            }
        }

    }

    }

