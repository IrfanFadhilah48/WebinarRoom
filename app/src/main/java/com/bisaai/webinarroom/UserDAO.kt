package com.bisaai.webinarroom

import androidx.room.*

@Dao
interface UserDAO {

    @Query("SELECT * FROM siswa")
    fun getAllSiswa(): List<UserEntity>

    @Insert
    fun insertSiswa(user: UserEntity)

    @Update
    fun updateSiswa(user: UserEntity)

    @Delete
    fun deleteSiswa(user: UserEntity)
}