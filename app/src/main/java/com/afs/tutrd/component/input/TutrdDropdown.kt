package com.afs.tutrd.component.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutrdDropdown(
    modifier: Modifier,
    title: String,
    options: List<String>,
    selectedOption: String,
    onClickOption: (option: String) -> Unit
) {
//    var selectedOptionState by remember { mutableStateOf(selectedOptionState) }
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier,
    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth(1f)
//                .height(44.dp)
//                .clip(RoundedCornerShape(size = 22.dp))
//                .background(
//                    color = Color.Transparent,
//                    shape = RoundedCornerShape(size = 22.dp)
//                )
//                .border(
//                    width = 1.dp,
//                    color = CheckBox_Unchecked,
//                    shape = RoundedCornerShape(size = 22.dp)
//                )
//                .padding(20.dp, 12.dp),
//        ) {
//
//            Text(
//                modifier = Modifier,
//                text = title)
//
//            Spacer(modifier = Modifier.weight(weight = 1.0f))
//            IconButton(
//                onClick = { isDropDownMenuExpanded = !isDropDownMenuExpanded },
//                modifier = Modifier
//                    .size(size=16.dp)
//                    .rotate(0f),
//                content = {
//                    Image(painter = painterResource(id =  R.drawable.icon_toggledown), contentDescription = "see more")
//                }
//            )
//        }

            ExposedDropdownMenuBox(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(size = 22.dp))
//                    .background(
//                        color = Color.Transparent,
//                        shape = RoundedCornerShape(size = 22.dp)
//                    )
//                    .border(
//                        width = 1.dp,
//                        color = CheckBox_Unchecked,
//                        shape = RoundedCornerShape(size = 22.dp)
//                    )
//                    .padding(vertical = 4.dp),
            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(1f)
//                        .height(44.dp)
//                        .clip(RoundedCornerShape(size = 22.dp))
//                        .background(
//                            color = Color.Transparent,
//                            shape = RoundedCornerShape(size = 22.dp)
//                        )
//                        .border(
//                            width = 1.dp,
//                            color = CheckBox_Unchecked,
//                            shape = RoundedCornerShape(size = 22.dp)
//                        )
//                        .padding(20.dp, 12.dp),
//                ) {
//
//                    Text(
//                        modifier = Modifier,
//                        text = title
//                    )
//                }
                TextField(
                    value = selectedOption,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                )
                ExposedDropdownMenu(
                    modifier = Modifier.fillMaxWidth(),
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(text = option) },
                            modifier = Modifier
                                .height(44.dp)
                                .padding(20.dp, 12.dp),
                            onClick = {
                                onClickOption(option)
                                expanded = false
                            }
                        )
                    }
                }
            }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDropdown() {
//    TutrdDropdown(Modifier, "과목 선택", arrayListOf("option1", "option2", "option3"))
}