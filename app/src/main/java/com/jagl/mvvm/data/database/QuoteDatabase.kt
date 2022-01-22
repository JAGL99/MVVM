package com.jagl.mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jagl.mvvm.data.database.dao.QuoteDao
import com.jagl.mvvm.data.database.entities.QuoteEntity

@Database(entities =[QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao

}