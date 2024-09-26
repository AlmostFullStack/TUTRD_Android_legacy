package com.afs.tutrd.presentation.classroom.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afs.tutrd.theme.Heading1
import com.afs.tutrd.theme.TutrdBackground

@Composable
internal fun ClassroomTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onClickTitle: () -> Unit
) {
    Box(
        modifier = modifier
            .background(TutrdBackground)
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
        ,
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
        ) {
            Text(
                modifier = Modifier,
                text = title,
                style = Heading1
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun PreviewHomeTopBar() {
    ClassroomTopBar(title = "과목 관리") {

    }
}