package com.bisaai.webinarroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel(){

    private val repository = DataRepository()
    var dataUser = MutableLiveData<List<UserEntity>>()

    fun insertData(data: UserEntity) {
        repository.insertData(data)
    }

    fun getAllData(){
        dataUser.value = repository.getAllData()
    }

    fun updateData(data: UserEntity){
        repository.updateData(data)
    }

    fun deleteData(data: UserEntity){
        repository.deleteData(data)
    }
}