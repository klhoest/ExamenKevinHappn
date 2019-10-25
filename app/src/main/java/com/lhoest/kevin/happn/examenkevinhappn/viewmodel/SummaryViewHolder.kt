package com.lhoest.kevin.happn.examenkevinhappn.viewmodel

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import java.text.DecimalFormat
import java.util.*


data class SummaryViewHolder(val day: Day) : Comparable<SummaryViewHolder> {

    private val df = DecimalFormat("0.0")

    val title: String
    val subTitle: String
    var temperature: String? = null
    val dateInSec: Int //used as an id
    val date: Date

    init {
        //I do not understand how a day can have multiple weathers in the api
        val firstWeather = day.weather?.filterNotNull()?.first()
        title = firstWeather?.main ?: ""
        subTitle = firstWeather?.description ?: ""
        val temperatureDouble = day.main?.temp?.toCelsius()
        temperatureDouble.let {
            temperature = "${df.format(temperatureDouble)} °C"
        }
        dateInSec = day.dt
        //see https://stackoverflow.com/questions/3371326/java-date-from-unix-timestamp
        date = Date(dateInSec.toLong()*1000)
    }

    override fun compareTo(other: SummaryViewHolder): Int = this.dateInSec - other.dateInSec
}

fun Double.toCelsius() = this - 273.15
