package com.afs.tutrd.presentation.classroom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.afs.tutrd.component.scaffold.TutrdScaffold

@Composable
fun ClassroomScreen(
    modifier: Modifier = Modifier,
    viewModel: ClassroomViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    TutrdScaffold {
        Box(modifier = modifier.fillMaxSize()) {
            Text(text = "classroom screen ${uiState.classroomList}")
        }
    }
}