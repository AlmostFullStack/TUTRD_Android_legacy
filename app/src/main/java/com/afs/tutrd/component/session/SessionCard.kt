package com.afs.tutrd.component.session

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.afs.tutrd.component.colordot.ColorDot
import com.afs.tutrd.component.colordot.DotSize

@Composable
fun SessionCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ColorDot(color = Color.Red, size = DotSize.Big)
        Column() {
            Row() {
                Text(
                    text = "고3 수학"
                )
            }
            Row() {
                Text(text = "12:00~14:00")
            }
            Row() {
                Text(text = "6회차 자료구조와 알고리즘-다익스트라")
                Button(
                    modifier = Modifier,
                    onClick = { /*TODO*/ }) {
                        Text(text = "수업 완료하기")
                }
            }
        }
    }
}