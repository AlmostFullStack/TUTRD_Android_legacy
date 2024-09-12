package com.afs.tutrd.component.chart

import android.graphics.RectF
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.afs.tutrd.theme.LightGray
import com.afs.tutrd.theme.MediumTitle2
import com.afs.tutrd.theme.Tutrd

@Composable
fun DonutChart(
    modifier: Modifier = Modifier,
    chartSize: Dp = 100.dp,
    width: Dp = 12.dp,
    progress: Int,
    total: Int
) {
    var animatedProgress by remember { mutableFloatStateOf(0f) }
    val sweepAngle by animateFloatAsState(
        targetValue = 360 * (animatedProgress / total),
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "sweepAngle"
    )

    LaunchedEffect(key1 = progress) {
        animatedProgress = progress.toFloat()
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.size(chartSize)
        ) {
            val outerRadius = (size.minDimension / 2) - width.toPx() / 2 // 가운데 정렬

            drawCircle(
                color = LightGray,
                radius = outerRadius,
                style = Stroke(width = width.toPx(), cap = StrokeCap.Round)
            )

            val arcRect = RectF(
                center.x - outerRadius,
                center.y - outerRadius,
                center.x + outerRadius,
                center.y + outerRadius
            )
            drawArc(
                color = Tutrd,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = arcRect.topLeft(),
                size = arcRect.size(),
                style = Stroke(width = width.toPx(), cap = StrokeCap.Butt)
            )
        }
        Text(
            text = "${progress}/$total",
            style = MediumTitle2,
            color = Color.Black
        )
    }
}

fun RectF.topLeft() = androidx.compose.ui.geometry.Offset(left, top)
fun RectF.size() = androidx.compose.ui.geometry.Size(width(), height())

@Preview
@Composable
private fun DonutChartPrev() {
    DonutChart(
        modifier = Modifier.size(100.dp).background(Color.White),
        progress = 2, total = 5
    )
}