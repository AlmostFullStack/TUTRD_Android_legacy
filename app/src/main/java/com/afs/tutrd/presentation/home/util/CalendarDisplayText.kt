package com.afs.tutrd.presentation.home.util

import java.time.Month
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

internal fun YearMonth.displayText(short: Boolean = false): String =
    "${year}년 ${month.displayText(short = short)}"

internal fun Month.displayText(short: Boolean = true): String {
    val style = if (short) TextStyle.SHORT else TextStyle.FULL
    return getDisplayName(style, Locale.KOREA)
}