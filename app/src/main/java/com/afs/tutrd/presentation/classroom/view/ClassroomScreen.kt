package com.afs.tutrd.presentation.classroom.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.afs.tutrd.component.scaffold.TutrdScaffold

@Composable
fun ClassroomScreen() {
    val scrollState = rememberScrollState()

    TutrdScaffold(
        topBar = { ClassroomTopBar(title = "과목 관리") { } }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(20.dp)

            ) {
                ClassroomCard()
                ClassroomCard()
                ClassroomCard()

            }

        }

    }
}