package com.farzin.weather.data.model.detail

data class AirPollution(
    val coord: Coord,
    val list: List<Pollution>,
)

data class Coord(
    val lat: Double,
    val lon: Double,
)

data class Pollution(
    val components: Components,
    val dt: Int,
    val main: Main,
)

data class Components(
    val co: Double,
    val nh3: Double,
    val no: Double,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    val pm2_5: Double,
    val so2: Double,
)

data class Main(
    val aqi: Int,
)

