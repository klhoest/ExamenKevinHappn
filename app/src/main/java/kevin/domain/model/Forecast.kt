package kevin.domain.model

import com.google.gson.annotations.SerializedName

data class Forecast(
        @SerializedName("cod") val cod: String?, //200
        @SerializedName("message") val message: Double?, //0.0036
        @SerializedName("cnt") val cnt: Int?, //40
        @SerializedName("list") val list: List<Day?>?,
        @SerializedName("city") val city: City?
)

data class City(
        @SerializedName("id") val id: Int?, //524901
        @SerializedName("name") val name: String?, //Moscow
        @SerializedName("coord") val coord: Coord?,
        @SerializedName("country") val country: String? //none
)

data class Coord(
        @SerializedName("lat") val lat: Double?, //55.7522
        @SerializedName("lon") val lon: Double? //37.6156
)

data class Day(
        @SerializedName("dt") val dt: Int?, //1485799200
        @SerializedName("main") val main: Main?,
        @SerializedName("weather") val weather: List<Weather?>?,
        @SerializedName("clouds") val clouds: Clouds?,
        @SerializedName("wind") val wind: Wind?,
        @SerializedName("snow") val snow: Any?,
        @SerializedName("sys") val sys: Sys?,
        @SerializedName("dt_txt") val dtTxt: String? //2017-01-30 18:00:00
)

data class Clouds(
        @SerializedName("all") val all: Int? //8
)

data class Wind(
        @SerializedName("speed") val speed: Double?, //4.77
        @SerializedName("deg") val deg: Double? //232.505
)

data class Sys(
        @SerializedName("pod") val pod: String? //n
)

data class Main(
        @SerializedName("temp") val temp: Double?, //261.45
        @SerializedName("temp_min") val tempMin: Double?, //259.086
        @SerializedName("temp_max") val tempMax: Double?, //261.45
        @SerializedName("pressure") val pressure: Double?, //1023.48
        @SerializedName("sea_level") val seaLevel: Double?, //1045.39
        @SerializedName("grnd_level") val grndLevel: Double?, //1023.48
        @SerializedName("humidity") val humidity: Int?, //79
        @SerializedName("temp_kf") val tempKf: Double? //2.37
)

data class Weather(
        @SerializedName("id") val id: Int?, //800
        @SerializedName("main") val main: String?, //Clear
        @SerializedName("description") val description: String?, //clear sky
        @SerializedName("icon") val icon: String? //02n
)
