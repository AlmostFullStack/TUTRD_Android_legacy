package com.afs.tutrd.presentation.session

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.afs.tutrd.R
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.component.sessioncard.SessionCard
import com.afs.tutrd.component.topbar.SessionTopBar
import com.afs.tutrd.presentation.shared.SharedClassroomViewModel
import com.afs.tutrd.theme.TutrdBackground

@Composable
fun DateDivider(date: Int) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(26.dp),
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        text = "${date}일")
}

@Composable
fun SessionScreen(
    modifier: Modifier,
    classroomViewModel: SharedClassroomViewModel = hiltViewModel()
) {
    val classroomState by classroomViewModel.classroomState.collect

    TutrdScaffold(
        topBar = { SessionTopBar(onClickTitle = { /*TODO*/ }, onAddSession = { /*TODO*/ }) }
    ) {
            paddingValues ->
        Column(
            modifier = Modifier
                .background(TutrdBackground)
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(44.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(20.dp),
                    content = {
                        Image(painter = painterResource(id =  R.drawable.month_prev), contentDescription = "see more")
                    }
                )
                Text(
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "7월")
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(20.dp)
                        .rotate(180f),
                    content = {
                        Image(painter = painterResource(id =  R.drawable.month_prev), contentDescription = "see more")
                    }
                )
            }
            LazyColumn(
                modifier = Modifier
                    .padding(top = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {


            }
        }

    }
}

@Preview
@Composable
fun Preview() {

}