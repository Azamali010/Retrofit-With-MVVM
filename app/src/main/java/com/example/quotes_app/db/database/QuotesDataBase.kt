package com.example.quotes_app.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quotes_app.db.dao.QuotesDao
import com.example.quotes_app.model.QuotesList
import com.example.quotes_app.model.Result


@Database(entities = [Result::class], version = 1)
abstract class QuotesDataBase: RoomDatabase() {

    abstract fun quotesDao() : QuotesDao

    companion object{
        @Volatile
        private var INSTANCE : QuotesDataBase? = null

        fun getDatabase(context: Context) :QuotesDataBase {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        QuotesDataBase::class.java,
                        "quoteDB")
                        .build()
                }

            }
            return INSTANCE!!
        }

    }


}