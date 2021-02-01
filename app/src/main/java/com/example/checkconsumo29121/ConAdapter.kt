package com.example.checkconsumo29121

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.checkconsumo29121.databinding.FragmentFirstBinding
import com.example.checkconsumo29121.databinding.ItemConsumptionBinding
import com.example.checkconsumo29121.model.Consumption

class ConAdapter : RecyclerView.Adapter<ConAdapter.ConsumptionVH> () {
    private var mlistConsumption = listOf<Consumption>()
    private val selectedConsumption = MutableLiveData<Consumption>()



    fun selectedItem(): LiveData<Consumption> = selectedConsumption

    fun update(listConsumption: List<Consumption>) {
        mlistConsumption = listConsumption
        notifyDataSetChanged()
    }

    inner class ConsumptionVH(private val binding: ItemConsumptionBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        fun bind(consumption: Consumption) {
            binding.tvnombreItem.text = consumption.item
            binding.tvcantidad.text = consumption.quantity.toString()
            binding.tvTotalActual.text = consumption.total.toString()

            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            selectedConsumption.value = mlistConsumption [adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumptionVH {
        return ConsumptionVH(ItemConsumptionBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = mlistConsumption.size


    override fun onBindViewHolder(holder: ConsumptionVH, position: Int) {
        val consumption = mlistConsumption[position]
        holder.bind(consumption)
    }

}