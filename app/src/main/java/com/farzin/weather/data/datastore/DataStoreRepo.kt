package com.farzin.weather.data.datastore

interface DataStoreRepo {

    suspend fun putString(key:String,value:String)
    suspend fun putBoolean(key:String,value:Boolean)
    suspend fun getString(key:String) : String?
    suspend fun getBoolean(key:String) : Boolean?

}