package com.afs.tutrd.presentation.classroom.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.R
import com.afs.tutrd.component.chart.DonutChart
import com.afs.tutrd.component.colordot.ColorDot
import com.afs.tutrd.component.colordot.DotSize
import com.afs.tutrd.component.tooltip.TooltipPopup
import com.afs.tutrd.theme.Gray45
import com.afs.tutrd.theme.Grey1
import com.afs.tutrd.theme.MediumBody2
import com.afs.tutrd.theme.MediumTitle3

@Deprecated("디자인 변경")
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

@Composable
fun ClassroomCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.White)
            .clickable { onClick() }
            .padding(16.dp)
    ){
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ColorDot(color = Color.Blue, size = DotSize.Medium)
                    Text(
                        modifier = Modifier,
                        style = MediumTitle3,
                        text = "고3 수학"
                    )
                }
                Text(
                    text = "강민석, 김진호, 홍진호",
                    style = MediumBody2,
                    color = Grey1
                )
                Text(
                    text = "매주 금요일 12:00-14:30",
                    style = MediumBody2,
                    color = Grey1
                )
            }
            DonutChart(
                modifier = Modifier
                    .size(100.dp),
                progress = 2,
                total = 5
            )
        }
    }
}

@Preview
@Composable
fun ClassroomCardPreview() {
    ClassroomCard(Modifier) {

    }
}