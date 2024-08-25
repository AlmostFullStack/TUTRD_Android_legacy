package com.afs.tutrd.presentation.home.view.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.afs.tutrd.component.colordot.ColorDot
import com.afs.tutrd.component.colordot.DotSize
import com.afs.tutrd.domain.manager.ClassroomManager
import com.afs.tutrd.domain.model.session.Session

@Composable
fun EventDots(
    sessions: ArrayList<Session> //Fixme
) {
    Box(
        modifier = Modifier
            .padding(top = 4.dp),
        contentAlignment = Alignment.Center

    ) {
        DotsGrid(tutorings = sessions)
    }
}

@Composable
fun DotsGrid(
    tutorings: ArrayList<Session> //Fixme
) {
    val rowsCount = if (tutorings.size <= 2) 1 else 2
    BoxWithConstraints {
        val maxWidth = this.maxWidth
        LazyColumn {
            items(2) { rowIndex ->
                val rangeStart = rowIndex * 2
                var rangeEnd = rangeStart + 1
                if (rangeEnd > tutorings.lastIndex) rangeEnd = tutorings.lastIndex // row로 표현될 list의 range를 계산, slice하여 row 생성
                RowOfGrid(tutorings.slice(rangeStart..rangeEnd), maxWidth/2)
            }
        }
    }
}

@Composable
fun RowOfGrid(rowList: List<Session>, columnWidth: Dp) {
    LazyRow {
        items(rowList.size) { index ->
            val item = rowList[index]
            ColorDot(color = ClassroomManager.getClassroomProfileColor(item.classRoomId), size = DotSize.Small)
        }
    }
}

//@Preview
//@Composable
//private fun a() {
//    EventDots(arrayListOf(SessionData("1", Color.Red), SessionData("2", Color.Blue), SessionData("3", Color.Green)))
//}