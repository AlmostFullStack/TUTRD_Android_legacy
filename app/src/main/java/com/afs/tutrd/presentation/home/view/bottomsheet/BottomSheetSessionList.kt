package com.afs.tutrd.presentation.home.view.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetSessionList(
    screenHeight: Dp
) {
    Column(
        Modifier
            .heightIn(min = 0.dp, max = screenHeight - 120.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

    }
}