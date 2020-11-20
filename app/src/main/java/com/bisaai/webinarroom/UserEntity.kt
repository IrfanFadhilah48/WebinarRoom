package com.bisaai.webinarroom

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "siswa")
@Parcelize
data class UserEntity(
//    @PrimaryKey(autoGenerate = true)
//    val uid: Int?,
    @PrimaryKey(autoGenerate = false)
    val nisn: String,
    @ColumnInfo(name = "nama")
    val nama: String,
    @ColumnInfo(name = "kelas")
    val kelas: String,
    @ColumnInfo(name = "alamat")
    val alamat: String
) : Parcelable