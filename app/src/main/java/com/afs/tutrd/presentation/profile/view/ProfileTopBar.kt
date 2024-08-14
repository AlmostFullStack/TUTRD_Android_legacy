package com.afs.tutrd.presentation.profile.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.afs.tutrd.theme.Heading1

@Composable
internal fun ProfileTopBar(
    title: String
) {
    Box(
        modifier = Modifier
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