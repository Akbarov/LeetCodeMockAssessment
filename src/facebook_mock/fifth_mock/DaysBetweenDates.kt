package facebook_mock.fifth_mock

import java.time.Duration
import java.time.LocalDate
import java.util.Calendar

fun main() {


}

private fun daysBetweenDates(date1: String, date2: String): Int {
    if (date2 == date1) return 0
    val start = if (date1 < date2) date1 else date2
    val end = if (date1 > date2) date1 else date2
    return getDays(start, end)
}

private fun getDays(start: String, end: String): Int {
    val list = start.split("-")
    val firstLocale = LocalDate.of(list.first().toInt(), list[1].toInt(), list[2].toInt())
    val list2 = end.split("-")
    val secondLocale = LocalDate.of(list2.first().toInt(), list2[1].toInt(), list2[2].toInt())
    return Duration.between(firstLocale.atStartOfDay(), secondLocale.atStartOfDay()).toDays().toInt()
}
