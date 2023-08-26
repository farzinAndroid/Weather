package com.farzin.weather.data.model.home

data class WeatherData(
    val base: String? = null,
    val clouds: Clouds? = null,
    val cod: Int? = null,
    val coord: Coord? = null,
    val dt: Int? = null,
    val id: Int? = null,
    val main: Main? = null,
    val name: String? = null,
    val sys: Sys? = null,
    val timezone: Int? = null,
    val visibility: Int? = null,
    val weather: List<Weather>? = null,
    val wind: Wind? = null,
)

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)

data class Main(
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class Coord(
    val lat: Double,
    val lon: Double
)

data class Clouds(
    val all: Int
)


data class Wind(
    val deg: Int,
    val speed: Double
)