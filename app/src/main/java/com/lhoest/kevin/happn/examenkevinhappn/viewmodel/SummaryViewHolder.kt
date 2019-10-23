package com.lhoest.kevin.happn.examenkevinhappn.viewmodel

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import java.text.DecimalFormat


data class SummaryViewHolder(val day: Day) {

    private val df = DecimalFormat("0.0")

    val title: String
    val subTitle: String
    var temperature: String? = null

    init {
        //I do not understand how a day can have multiple weathers in the api
        val firstWeather = day.weather?.filterNotNull()?.first()
        title = firstWeather?.main ?: ""
        subTitle = firstWeather?.description ?: ""
        val temperatureDouble = day.main?.temp?.toCelsius()
        temperatureDouble.let {
            temperature = "${df.format(temperatureDouble)} °C"
        }
    }
}

fun Double.toCelsius() = this - 273.15
