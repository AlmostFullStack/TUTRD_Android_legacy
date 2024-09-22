package com.afs.tutrd.component.buttetlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun BulletPoint() {
    Box(
        modifier = Modifier.size(22.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(4.dp)
                .background(Color.Black, shape = CircleShape),
        )
    }
}

@Composable
fun BulletListItem(
    content: String,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        BulletPoint()
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier,
            fontSize = 16.sp,
            text = content
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BulletListItem(content = "Hello world!")
}