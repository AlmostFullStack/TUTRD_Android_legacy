package com.afs.tutrd.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.theme.Button_Disabled
import com.afs.tutrd.theme.Disabled
import com.afs.tutrd.theme.Tutrd

@Composable
fun CTAButton(
    modifier: Modifier,
    label: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        contentPadding = PaddingValues(horizontal = 16.dp),
        colors = ButtonColors(contentColor = Color.White, containerColor = Tutrd, disabledContainerColor = Button_Disabled, disabledContentColor = Disabled),
        modifier = modifier
            .height(44.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp
        )
    }
}