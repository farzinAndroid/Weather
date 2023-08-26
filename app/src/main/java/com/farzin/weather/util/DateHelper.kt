package com.farzin.weather.util

import android.util.Log
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object DateHelper {


    fun getCurrentDate(): String{
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return currentDate.format(formatter)
    }


    fun getCurrentDate2(): String{
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return currentDate.format(formatter)
    }


    fun extractTime(date:String):String {
        val inputPattern = "yyyy-MM-dd HH:mm:ss"
        val outputPattern = "HH:mm"

        // Parse the server response string to a LocalDateTime object
        val dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(inputPattern))


        // Format the LocalDateTime object to the desired output format
        val formattedTime = dateTime.format(DateTimeFormatter.ofPattern(outputPattern))

        return formattedTime
    }


    fun extractDate(date:String):String {
        val inputPattern = "yyyy-MM-dd HH:mm:ss"
        val outputPattern = "dd-MM-yyyy"

        // Parse the server response string to a LocalDateTime object
        val dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(inputPattern))


        // Format the LocalDateTime object to the desired output format
        val formattedDate = dateTime.format(DateTimeFormatter.ofPattern(outputPattern))

        return formattedDate
    }


    fun unixToNormalTime(unix:Long) : String {
        val dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(unix), ZoneId.systemDefault())
        return dateTime.toString()
    }

    fun getTimeAsUnix() : String {
        val currentTimestamp = Instant.now().epochSecond
        return currentTimestamp.toString()
    }


}