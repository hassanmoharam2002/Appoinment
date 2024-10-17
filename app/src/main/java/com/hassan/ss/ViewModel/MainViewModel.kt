package com.hassan.ss.ViewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.hassan.ss.Domain.CategoryModel
import com.hassan.ss.Domain.DoctorModel

class MainViewModel() :ViewModel() {
private val firbaseDataBase=FirebaseDatabase.getInstance()
    private val _category = MutableLiveData<MutableList<CategoryModel>>()
    private val _Doctors = MutableLiveData<MutableList<DoctorModel>>()

    val category :LiveData<MutableList<CategoryModel>> = _category
    val doctors :LiveData<MutableList<DoctorModel>> = _Doctors



    fun   loadCategory(){
        val Ref=firbaseDataBase.getReference("Category")

        Ref.addValueEventListener(object:ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val lists= mutableListOf<CategoryModel>()
                for (childSnapshot in snapshot.children){
                    val list=childSnapshot.getValue(CategoryModel::class.java)
                    if (list!=null){
                        lists.add(list)

                    }
                }
                _category.value=lists

            }

            override fun onCancelled(error: DatabaseError) {

            }

        }
        )
    }
    fun loudDoctors(){
        val Ref=firbaseDataBase.getReference("Doctors")
        Ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              val lists= mutableListOf<DoctorModel>()
                for (childSnapChot in snapshot.children){
                    val list=childSnapChot.getValue(DoctorModel::class.java)
                    if (list!=null){
                        lists.add(list)

                    }
                }
                _Doctors.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}