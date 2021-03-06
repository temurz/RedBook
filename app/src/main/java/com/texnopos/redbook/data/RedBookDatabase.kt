package com.texnopos.redbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.data.model.Animal

@Database(entities = [Animal::class],version = 1,  exportSchema = false)
abstract class RedBookDatabase : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE : RedBookDatabase

        fun getInstance(context: Context) : RedBookDatabase =
            Room.databaseBuilder(
                context,
                RedBookDatabase::class.java,
                "book-database.db"
            )
                .createFromAsset("book-database.db")
                    .allowMainThreadQueries()
                .build()
    }

    abstract fun dao() : AnimalDao
}