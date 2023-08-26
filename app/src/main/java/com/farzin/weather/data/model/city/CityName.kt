package com.farzin.weather.data.model.city

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.farzin.weather.util.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CityName(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
)
