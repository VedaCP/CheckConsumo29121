package com.example.checkconsumo29121

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.checkconsumo29121.model.ConDataBase
import com.example.checkconsumo29121.model.ConRepository
import com.example.checkconsumo29121.model.Consumption
import kotlinx.coroutines.launch

class ConViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: ConRepository
    val allConsumption : LiveData<List<Consumption>>

    init {
        val consumptionDao = ConDataBase.getDataBase(application).getConsumptionDao()
        repository = ConRepository(consumptionDao)
        allConsumption = repository.listAllConsumption
    }

    fun insertConsumption(consumption: Consumption) = viewModelScope.launch {
        repository.createConsumption(consumption)
    }

    fun deleteAllConsumption() = viewModelScope.launch {
        repository.deleteAll()
    }

    private var selectedConsumption: MutableLiveData<Consumption> = MutableLiveData()

    fun selected(consumption: Consumption?): LiveData<Consumption> {
        selectedConsumption.value = consumption
        return selectedConsumption
    }

    fun selectedItem(): LiveData<Consumption> = selectedConsumption
}