package com.afs.tutrd.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.theme.CheckBox_Unchecked


@Composable
fun TutrdPlainText(
    modifier: Modifier,
    onSubmit: ((text: String) -> Unit)?,
    placeholder: String?,
) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = modifier
            .height(44.dp)
            .clip(RoundedCornerShape(size = 22.dp))
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(size = 22.dp)
            )
            .border(
                width = 1.dp,
                color = CheckBox_Unchecked,
                shape = RoundedCornerShape(size = 22.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .padding(start = 20.dp)
            ) {
                if (textState.text.isEmpty() && !placeholder.isNullOrEmpty()) {
                    Text(
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(  // Add this line
                                includeFontPadding = false,
                            )
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(align = Alignment.CenterVertically),
                        text = placeholder,
                        fontSize = 16.sp,
                        color = Color.Gray)
                }
                BasicTextField(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp),
                    value = textState,
                    onValueChange = { textState = it },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        platformStyle = PlatformTextStyle(  // Add this line
                            includeFontPadding = false,
                        )
                    ),
                    interactionSource = interactionSource,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        if(textState.text.isNotEmpty()) {
                            onSubmit?.invoke(textState.text)
                            keyboardController?.hide()
                        }
                    })
                )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewInput() {
    TutrdPlainText(
        modifier = Modifier.fillMaxWidth(),
        onSubmit = {},
        placeholder = "입력하세요"
    )
}