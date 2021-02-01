package com.example.checkconsumo29121.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.checkconsumo29121.model.Consumption

@Dao
interface ConsumptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConsumption(consumption: Consumption)

    @Query("SELECT * FROM consumption_table")
    fun getAllConsumption(): LiveData<List<Consumption>>

    @Query("DELETE FROM consumption_table")
    fun deleteAllConsumption()

    @Delete
    suspend fun deleteConsumption(consumption: Consumption)



}