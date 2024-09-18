package com.afs.tutrd.component.checklist

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.theme.CheckBox_Unchecked


@Composable
private fun CheckBoxUnSelected() {
    Box(
        modifier = Modifier
            .size(22.dp)
            .clip(RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = CheckBox_Unchecked, shape = RoundedCornerShape(4.dp))
            .clickable { }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CheckListInputItem(
    onCheck: () -> Unit,
    onUnCheck: () -> Unit,
) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }


    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        CheckBoxUnSelected()
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (textState.text.isEmpty()) {
                Text(text = "과제를 입력하세요",fontSize = 16.sp, color = Color.Gray)
            }

            BasicTextField(
                value = textState,
                onValueChange = { textState = it },
                interactionSource = interactionSource,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun P() {
    CheckListInputItem(onCheck = { /*TODO*/ }, onUnCheck = {})
}