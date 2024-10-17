package com.hassan.ss.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hassan.ss.Adapter.CategoryAdapter
import com.hassan.ss.Adapter.TopDoctorAdapter

import com.hassan.ss.ViewModel.MainViewModel

import com.hassan.ss.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewmodel= MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()
        initTopDoctor()

    }


    private fun initTopDoctor(){
        binding.apply {
            progressBarTopDoctor.visibility=View.VISIBLE
            viewmodel.doctors.observe(this@MainActivity,Observer{

                recyclerViewTopDoctor.layoutManager=
                    LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewTopDoctor.adapter=TopDoctorAdapter(it)
                progressBarTopDoctor.visibility=View.GONE
            })
            viewmodel.loudDoctors()
            doctorlistTxt.setOnClickListener {

                startActivity(Intent(this@MainActivity,TopDoctorsActivity::class.java))
            }
        }

    }
    private fun initCategory(){
        binding.progressBarCategory.visibility= View.VISIBLE
        viewmodel.category.observe(this, Observer {
            binding.viewCategory.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            binding.viewCategory.adapter=CategoryAdapter(it)
            binding.progressBarCategory.visibility=View.GONE
        })


        viewmodel.loadCategory()



    }
}