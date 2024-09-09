package com.afs.tutrd.component.colordot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afs.tutrd.theme.Tutrd

sealed class DotSize {
    data object Big : DotSize()
    data object Small : DotSize()
}


@Composable
fun ColorDot(
    color: Color,
    size: DotSize
) {
    Icon(
        imageVector = Icons.Filled.Check,
        contentDescription = "eventDot",
        modifier = Modifier
            .size(if (size == DotSize.Small) 8.dp else 14.dp)
            .background(color, shape = CircleShape),
        tint = color
    )
}

@Preview
@Composable
fun preview() {
    Row() {
        ColorDot(
            Tutrd,
            DotSize.Big
        )
        ColorDot(
            Color.Green,
            DotSize.Small
        )
    }
}