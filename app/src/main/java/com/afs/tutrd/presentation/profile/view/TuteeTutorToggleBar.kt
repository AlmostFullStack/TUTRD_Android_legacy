package com.afs.tutrd.presentation.profile.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TuteeTutorToggleBar() {

    val toggleText = "튜티로 전환" //FIXME
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = Color(247, 247, 245),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            text = toggleText
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            colors = SwitchDefaults.colors(

            ),
            checked = checked,
            onCheckedChange = { checked = it} //FIXME 전환로직 삽입
        )
    }
}
//
//@Preview
//@Composable
//fun preview() {
//    TuteeTutorToggleBar()
//}