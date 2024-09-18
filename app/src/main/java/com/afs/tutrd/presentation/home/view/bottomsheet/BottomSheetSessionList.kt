package com.afs.tutrd.presentation.home.view.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.afs.tutrd.component.sessioncard.SessionCard

@Composable
fun BottomSheetSessionList(
    screenHeight: Dp,
    navigateSession: () -> Unit
) {
    Column(
        Modifier
            .heightIn(min = 0.dp, max = screenHeight - 120.dp)
            .fillMaxSize()
            .padding(horizontal=4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SessionCard(navigateSession)
        SessionCard(navigateSession)
        SessionCard(navigateSession)
        SessionCard(navigateSession)
    }
}