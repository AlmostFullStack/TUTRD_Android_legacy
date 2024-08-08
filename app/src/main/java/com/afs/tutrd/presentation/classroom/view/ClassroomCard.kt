package com.afs.tutrd.presentation.classroom.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.R
import com.afs.tutrd.component.colordot.ColorDot
import com.afs.tutrd.component.colordot.DotSize
import com.afs.tutrd.component.tooltip.TooltipPopup
import com.afs.tutrd.theme.Gray45

@Composable
fun ClassroomCard() {
    Column(
        modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White),
        verticalArrangement = Arrangement.spacedBy(10.dp)
        )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Aligns all elements vertically at the center
        ) {
            Box(
                modifier = Modifier
                .padding(end = 6.dp)) {
                ColorDot(color = Color.Blue, size = DotSize.Big)
            }
            Text(
                modifier = Modifier,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                text = "고3 수학"
            )
            Box(
                modifier = Modifier
                    .width(17.dp)
                    .padding(horizontal = 8.dp)
                    .height(12.dp)
                    .background(color = Color.Black)


            )
            Text(
                textAlign = TextAlign.Center,
                text = "강민석"

            )
        }
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "다음 진도")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "자료구조와 알고리즘-다익스트라 기본개념") //Fixme
        }
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "진행 횟수")
            TooltipPopup(
                modifier = Modifier
                    .padding(start = 8.dp),
                requesterView = { modifier ->
                    Icon(
                        modifier = modifier,
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "TooltipPopup",
                        tint = Gray45,
                    )
                },
                tooltipContent = {
                    androidx.compose.material.Text(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(vertical = 8.dp),
                        text = "마지막 정산일로부터",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight.Medium,
                        ),
                        color = Color.White,
                    )
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "4회(총 12회)")
        }
        Row(
            modifier = Modifier.alpha(0.5f),
        ) {
            Text(
                modifier = Modifier,
                text = "다음 교육비 납부일")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "2024.08.03 (화)")
        }

    }
}

@Preview
@Composable
fun a() {
    ClassroomCard()
}