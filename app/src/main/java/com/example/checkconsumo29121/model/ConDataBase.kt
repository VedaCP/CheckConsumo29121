package com.example.checkconsumo29121.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Consumption:: class], version = 1)
abstract class ConDataBase: RoomDatabase() {

    abstract fun getConsumptionDao() : ConsumptionDao
    companion object {
        @Volatile
        private var INSTANCE : ConDataBase? = null

        fun getDataBase(context: Context): ConDataBase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    ConDataBase::class.java, "taskDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}