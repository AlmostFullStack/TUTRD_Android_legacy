package com.afs.tutrd.presentation.lecture

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.afs.tutrd.component.scaffold.TutrdScaffold

@Composable
fun LectureScreen(modifier: Modifier) {
    TutrdScaffold {
        Box(modifier = modifier.fillMaxSize()) {
            Text(text = "lecture screen")
        }
    }
}