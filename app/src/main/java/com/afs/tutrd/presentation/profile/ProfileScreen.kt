package com.afs.tutrd.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.afs.tutrd.component.scaffold.TutrdScaffold

@Composable
fun ProfileScreen(modifier: Modifier) {
    TutrdScaffold {
        Box(modifier = modifier.fillMaxSize()) {
            Text(text = "profile screen")
        }
    }
}