package com.afs.tutrd.component.checklist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.R
import com.afs.tutrd.theme.CheckBox_Unchecked
import com.afs.tutrd.theme.Tutrd

@Composable
private fun CheckBoxSelected() {
    Box(
        modifier = Modifier
            .size(22.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Tutrd),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id =  R.drawable.icon_check), contentDescription = "check icon")
    }
}

@Composable
private fun CheckBoxUnSelected() {
    Box(
        modifier = Modifier
            .size(22.dp)
            .clip(RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = CheckBox_Unchecked, shape = RoundedCornerShape(4.dp))
            .clickable {  }
    )
}

@Composable
fun CheckListItem(
    checked: Boolean,
    content: String,
    onCheck: () -> Unit,
    onUnCheck: () -> Unit,
) {
    var checkBoxState by remember { mutableStateOf(checked) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (checked) CheckBoxSelected()
        else CheckBoxUnSelected()

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier,
            fontSize = 16.sp,
            text = content
        )
    }
}

@Preview
@Composable
fun Preview() {
    CheckBoxUnSelected()
}