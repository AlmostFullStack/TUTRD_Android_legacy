package com.afs.tutrd.domain.model.classroom
import com.afs.tutrd.domain.model.repetition.Repetition
import com.afs.tutrd.domain.model.repetition.RepetitionType
import java.time.LocalDate
import java.time.YearMonth

data class Schedule(
    val startDate: LocalDate,
    val repetition: Repetition,
    val endDate: LocalDate?,
    val classHours: Float
) {
    fun getNextSessionDate(date: LocalDate): LocalDate? {
        when (repetition.type) {
            RepetitionType.NONE -> return null
            RepetitionType.DAILY -> {
                date.plusDays(repetition.interval.toLong())
            }

            RepetitionType.WEEKLY -> {
                date.plusWeeks(repetition.interval.toLong())
            }

            RepetitionType.MONTHLY -> {
                date.plusMonths(repetition.interval.toLong())
            }

            RepetitionType.YEARLY -> {
                date.plusYears(repetition.interval.toLong())
            }
        }
        if (endDate != null && date.isBefore(endDate)) {
            return date
        }
        return null
    }

    fun getFirstSessionDateInMonth(month: YearMonth) {

    }
}
