package com.afs.tutrd.presentation.classroom.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.component.topbar.ClassroomTopBar

@Composable
fun ClassroomScreen() {
    TutrdScaffold(
        topBar = { ClassroomTopBar(title = "과목 관리") { } }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues).padding(horizontal = 20.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            items(3) {
                ClassroomCard { }
            }
        }
    }
}