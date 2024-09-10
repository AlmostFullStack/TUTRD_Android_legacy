package com.afs.tutrd.component.sessioncard

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.R
import com.afs.tutrd.component.button.SessionCompleteButton
import com.afs.tutrd.component.card.Card
import com.afs.tutrd.component.colordot.ColorDot
import com.afs.tutrd.component.colordot.DotSize
import com.afs.tutrd.domain.model.tutoring.SessionStatus

@Composable
fun SessionCard(
// classroom, tutee, session
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(modifier = Modifier
                .height(26.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ColorDot(color = Color.Blue, size = DotSize.Big)
                Text(
                    modifier = Modifier
                        .padding(start = 12.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "고3 수학")
                Box(modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .height(16.dp)
                    .width(1.dp)
                    .background(Color.Black))
                Text(text = "강민석")
                Spacer(modifier = Modifier
                    .weight(1.0f))
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(size=20.dp),
                    content = {
                        Image(painter = painterResource(id =  R.drawable.button_more), contentDescription = "see more")
                    }
                )
            }
            Row(
                modifier = Modifier
                    .height(26.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier
                    .width(26.dp))
                Text(modifier = Modifier,
                    fontSize = 16.sp,
                    letterSpacing = (-0.5).sp,
                    fontWeight = FontWeight.Medium,
                    text = "12:00 ~ 14:00")
            }
            Row(
                modifier = Modifier
                    .height(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(26.dp))
                Text(modifier = Modifier
                    .weight(1.0f)
                    .alpha(0.5f),
                    fontSize = 16.sp,
                    text = "6회차 자료구조와 알고리즘")
                SessionCompleteButton(status = SessionStatus.ROUTINE, isDone = false)
            }
        }
    }
}

@Preview
@Composable
fun preview() {
    SessionCard()
}