package com.afs.tutrd.presentation.home.view.calendar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.theme.TutrdBackground
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import java.time.LocalDate

@Composable
fun Day(
    day: CalendarDay,
    clickedDate: LocalDate,
    onDateClick: (CalendarDay) -> Unit,
) {
    val isMonthDate = day.position == DayPosition.MonthDate
    val isEqual = day.date.isEqual(clickedDate)
    val isAfter = day.date.isAfter(clickedDate)
    val dateBoxColor = animateColorAsState(
        targetValue =
        if (isMonthDate && isEqual) Color.Black
        else if (isMonthDate) TutrdBackground
        else Color.Transparent, label = "color",
        animationSpec = tween(
            durationMillis = 300, // 애니메이션이 1초 동안 지속됨
        )
    )
    val dateTextColor =
        if (isMonthDate && isEqual) Color.White
        else if (isMonthDate) Color.Black
        else Color.Gray

    Box(
        modifier = Modifier
            .aspectRatio(0.9f) // This is important for square sizing!
            .clickable(onClick = { onDateClick(day) }),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(dateBoxColor.value, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    fontSize = 16.sp,
                    text = day.date.dayOfMonth.toString(),
                    color = dateTextColor,
                )
            }
//            EventDots(arrayListOf(Tutoring("1", Color.Red), Tutoring("2", Color.Blue), Tutoring("3", Color.Green)))
        }
    }
}
