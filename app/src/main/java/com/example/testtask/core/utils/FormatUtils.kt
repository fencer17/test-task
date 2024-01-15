package com.example.testtask.core.utils

import com.example.testtask.core.extensions.orZero
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


object FormatUtils {
    private const val datePattern = "yyyy-MM-dd'T'HH:mm:ssX"

    fun formatDateStringToMillis(dateStr: String): Long {
        val dateFormat = SimpleDateFormat(datePattern, Locale.getDefault())
        val date: Date? = dateFormat.parse(dateStr)
        return date?.time.orZero()
    }
}