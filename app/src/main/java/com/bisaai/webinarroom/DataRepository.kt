package com.bisaai.webinarroom

class DataRepository {

    private var userDao: UserDAO? = null

    init {
        userDao = App.getDatabase()?.userDao()
    }

    fun insertData(data: UserEntity) {
        userDao?.insertSiswa(data)
    }

    fun getAllData(): List<UserEntity>? = userDao?.getAllSiswa()

    fun updateData(data: UserEntity){
        userDao?.updateSiswa(data)
    }

    fun deleteData(data: UserEntity){
        userDao?.deleteSiswa(data)
    }
}