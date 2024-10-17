package com.hassan.ss.Activity

import android.content.Intent

import android.os.Bundle
import com.hassan.ss.databinding.ActivityIntroBinding


class intro : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startbtn.setOnClickListener {
                startActivity(Intent(this@intro, MainActivity::class.java))
            }
        }
    }
}