package com.afs.tutrd.presentation.home.view.calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import java.time.LocalDate

@Composable
fun Day(
    day: CalendarDay,
    clickedDate: LocalDate,
    onDateClick: (LocalDate) -> Unit,
) {
    val isMonthDate = day.position == DayPosition.MonthDate
    val isEqual = day.date.isEqual(clickedDate)
    val isAfter = day.date.isAfter(clickedDate)
    val dateBoxColor =
        if (isMonthDate && isEqual) Color.Black
        else if (isMonthDate) Color.White
        else Color.Transparent
    val dateTextColor =
        if (isMonthDate && isEqual) Color.White
        else if (isMonthDate) Color.Black
        else Color.Gray

    Box(
        modifier = Modifier
            .aspectRatio(0.9f) // This is important for square sizing!
            .clickable(
                onClick = {
                    if (day.position == DayPosition.MonthDate) onDateClick(day.date)
                }
            )
           ,
        contentAlignment = Alignment.TopCenter,
    ) {
        Column {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(dateBoxColor, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    fontSize = 16.sp,
                    text = day.date.dayOfMonth.toString(),
                    color = dateTextColor,

                    )
            }
            Box(modifier = Modifier) {

            }
        }
    }
}
