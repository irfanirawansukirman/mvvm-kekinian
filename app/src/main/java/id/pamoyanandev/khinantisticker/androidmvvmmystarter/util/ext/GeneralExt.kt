package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*

fun String.dateFormatFromTimeString(
    date: String,
    oldFormat: String,
    newFormat: String,
    isLocale: Boolean
): String {
    val dateTimeMillis = if (!TextUtils.isEmpty(date)) {
        SimpleDateFormat(oldFormat, isLocale.isLocaleDate(isLocale)).parse(date).time
    } else {
        0.toLong()
    }

    val calendar = Calendar.getInstance()
    calendar.timeInMillis = dateTimeMillis

    return if (dateTimeMillis != 0.toLong() && dateTimeMillis != null) {
        SimpleDateFormat(newFormat, isLocale.isLocaleDate(isLocale))
            .format(calendar.time)
    } else {
        SimpleDateFormat(newFormat, isLocale.isLocaleDate(isLocale))
            .format(System.currentTimeMillis())
    }
}


fun Boolean.isLocaleDate(
    isLocale: Boolean
): Locale {
    return if (isLocale) Locale("id", "ID")
    else Locale("en", "EN")
}