package com.example.checkconsumo29121.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "consumption_table")
class Consumption(@PrimaryKey(autoGenerate = true)
                  val id: Int = 0,
                  val item: String,
                  val intemPrice: Int,
                  val quantity: Int,
                  val total: Int)
