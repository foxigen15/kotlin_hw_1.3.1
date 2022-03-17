package ru.netology

fun main() {

    val seconds = 60 * 60 * 11
    println(agoToText(seconds))
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) в сети только что"
        in 61..60 * 60 -> "был(а) в сети ${minutesToString(seconds)} назад"
        in (60 * 60 + 1)..(24 * 60 * 60) -> "был(а) в сети ${hoursToString(seconds)} назад"
        in (24 * 60 * 60 + 1)..(24 * 2 * 60 * 60) -> "был(а) в сети сегодня"
        in (24 * 2 * 60 * 60 + 1)..(24 * 3 * 60 * 60) -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }
}

fun minutesToString(seconds: Int): String {
    val minutes = seconds / 60
    val minutesLength = minutes.toString().length
    val penultimateNumber = if (minutesLength > 1) minutes.toString()[minutesLength - 2] else '0'
    val lastNumber = minutes.toString()[minutesLength - 1]
    return when {
        penultimateNumber != '1' && lastNumber == '1' -> "$minutes минуту"
        penultimateNumber != '1' && (lastNumber == '2' || lastNumber == '3' || lastNumber == '4') -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursToString(seconds: Int): String {
    val hours = seconds / 60 / 60
    val hoursLength = hours.toString().length
    val penultimateNumber = if (hoursLength > 1) hours.toString()[hoursLength - 2] else '0'
    val lastNumber = hours.toString()[hoursLength - 1]
    return when {
        penultimateNumber != '1' && lastNumber == '1' -> "$hours час"
        penultimateNumber != '1' && (lastNumber == '2' || lastNumber == '3' || lastNumber == '4') -> "$hours часа"
        else -> "$hours часов"
    }
}