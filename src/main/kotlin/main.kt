const val timeMinute = 60
const val timeHour = 3600
const val timeDay = 86400
const val timeDayYesterday = 172800
const val timeBeforeYesterday = 259200
const val time = 2753
val list = listOf("только что", "вчера", "позавчера", "давно")
val listmin = listOf("минуту", "минут", "минуты")
val listHour = listOf("час", "часа", "часов")
const val userViktor = "Виктор"

fun main() {

    when {
        time < timeMinute -> println("$userViktor был " + list[0]) //только что
        time in timeDay..timeDayYesterday -> println("$userViktor был " + list[1]) //вчера
        time in timeDayYesterday until timeBeforeYesterday -> println("$userViktor был " + list[2]) // позавчера
        time > timeBeforeYesterday -> println("$userViktor был " + list[3]) //давно
        else -> timeMinHour()
    }
}

fun timeMinHour() {
    val laterTimeMinHour = if (time in timeMinute until timeHour) {
        min()
    } else {
        (time in timeHour until timeDay)
        hour()
    }
    println("$userViktor был $laterTimeMinHour назад")
}

fun min(): String {
    val min = (time / (1 * 60)) % 60
    return when {
        min % 10 == 0 -> "$min ${listmin[1]}" //минут
        min % 10 == 1 -> "$min ${listmin[0]}" //минуту
        min % 10 == 2 || min % 10 == 3 || min % 10 == 4 -> "$min ${listmin[2]}" //минуты
        else -> "$min ${listmin[1]}" //минут
    }
}

fun hour(): String {
    val hour = (time / (1 * 60 * 60)) % 24
    return when {
        hour == 11 -> "$hour ${listHour[2]}" //часов
        hour % 10 == 1 -> "$hour ${listHour[0]}" // час
        hour % 1 == 2 || hour % 1 == 3 || hour % 1 == 4 -> "$hour ${listHour[1]}" //часа
        else -> "$hour ${listHour[2]}" //часов
    }
}
/*
1 минуту          21 минута     1 час      11 часов            21 час
2 минуты          22 минуты     2 часа     12 часов            22 часа
3 минуты          23 минуты     3 часа     13 часов            23 часа
4 минуты          24 минуты     4 часа     14 часов
5 минут           25 минут      5 часов    15 часов
6 минут           26 минут      6 часов    16 часов
7 минут           27 минут      7 часов    17 часов
8 минут           28 минут      8 часов    18 часов
9 минут           29 минут      9 часов    19 часов
10 минут          30 минут      10 часов   20 часов
 */