package com.afs.tutrd.presentation.classroom.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.afs.tutrd.component.scaffold.TutrdScaffold

@Composable
fun ClassroomScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    TutrdScaffold(
        topBar = {
            ClassroomTopBar(
                title = "과목 관리"
            ) { }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .padding(paddingValues)
                .padding(20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            repeat(10) {
                ClassroomCard { }
            }
        }
    }
}