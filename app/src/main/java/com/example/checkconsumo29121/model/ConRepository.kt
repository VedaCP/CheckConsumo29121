package com.example.checkconsumo29121.model

import androidx.lifecycle.LiveData

class ConRepository (private val consumptionDao: ConsumptionDao){

    val listAllConsumption : LiveData<List<Consumption>> = consumptionDao.getAllConsumption()

    suspend fun createConsumption(consumption: Consumption) {
        consumptionDao.insertConsumption(consumption)
    }

    suspend fun deleteConsumption(consumption: Consumption) {
        consumptionDao.deleteConsumption(consumption)
    }

    suspend fun deleteAll(){
        consumptionDao.deleteAllConsumption()
    }


}