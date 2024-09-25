package com.afs.tutrd.presentation.shared.view.addsession


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.component.button.CTAButton
import com.afs.tutrd.component.input.TutrdDatePicker
import com.afs.tutrd.component.input.TutrdDropdown
import com.afs.tutrd.component.input.TutrdTimePicker
import com.afs.tutrd.domain.model.repetition.RepetitionType

@Composable
fun AddSessionModalContents(
    allowRepetition: Boolean
) {
    var repetitionTypeState by remember { mutableStateOf(RepetitionType.NONE.toString()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "과목 선택"
                )
                /* TODO: Classroom Dropdown */
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "시작"
                )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    TutrdDatePicker(
                        modifier = Modifier.weight(1f)
                    )
                    TutrdTimePicker(
                        modifier = Modifier.weight(1f)
                    )
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "수업 시간"
                )
                /* TODO: Class hour Dropdown */
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "반복"
                )
                TutrdDropdown(
                    modifier = Modifier.fillMaxWidth(),
                    title = "반복",
                    selectedOption = repetitionTypeState,
                    onClickOption = { option -> repetitionTypeState = option } ,
                    options = listOf(
                        RepetitionType.NONE.repetitionType,
                        RepetitionType.DAILY.repetitionType,
                        RepetitionType.WEEKLY.repetitionType,
                        RepetitionType.MONTHLY.repetitionType,
                        RepetitionType.YEARLY.repetitionType,
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "종료일"
                )
                TutrdDatePicker(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        CTAButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            label = "등록하기"
        ) {

        }
    }
}