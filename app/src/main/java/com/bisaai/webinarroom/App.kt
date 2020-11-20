package com.bisaai.webinarroom

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class App: Application() {

    companion object{
        var db: AppDatabase? = null
        fun getDatabase(): AppDatabase? = db
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "user"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}