package com.afs.tutrd.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.domain.model.session.SessionStatus
import com.afs.tutrd.theme.Button_Disabled
import com.afs.tutrd.theme.Disabled
import com.afs.tutrd.theme.Tutrd

@Composable
fun SessionCompleteButton(
    status: SessionStatus,
    isDone: Boolean
) {
    val buttonText =
        if (status == SessionStatus.CANCELED) "취소된 수업"
        else if (isDone) "완료된 수업"
        else "수업 완료하기"

    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(horizontal = 16.dp),
        colors = ButtonColors(contentColor = Color.White, containerColor = Tutrd, disabledContainerColor = Button_Disabled, disabledContentColor = Disabled),
        modifier = Modifier
            .height(32.dp),
        enabled = !isDone
    ) {
        Text(
            text = buttonText,
            fontSize = 13.sp
        )
    }
}

@Preview
@Composable
fun preview() {
    SessionCompleteButton(
        SessionStatus.ROUTINE,
        isDone = true
    )
}