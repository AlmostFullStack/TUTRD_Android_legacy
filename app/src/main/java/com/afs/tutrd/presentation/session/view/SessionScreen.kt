package com.afs.tutrd.presentation.session.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.component.card.Card
import com.afs.tutrd.component.checklist.CheckListInputItem
import com.afs.tutrd.component.checklist.CheckListItem
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.theme.TutrdBackground

@Composable
fun SessionScreen(modifier: Modifier) {
    TutrdScaffold(
        topBar = {
            SessionTopBar(
                onClickPrev = { },
                onClickMore = { }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(TutrdBackground)
                .padding(paddingValues)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Card {
                Text(
                    fontSize = 18.sp,
                    text = "진도")
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
//                    CheckListItem(checked = true, content = "P.202 예제 2번 풀기")
//                    CheckListItem(checked = true, content = "P.202 예제 3번 풀기")
                }
            }
            Card {
                Text(
                    fontSize = 18.sp,
                    text = "과제")
                Column(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    CheckListItem(
                        checked = true,
                        content = "P.202 예제 2번 풀기",
                        onCheck = {},
                        onUnCheck = {}
                    )
                    CheckListItem(
                        checked = true,
                        content = "P.202 예제 3번 풀기",
                        onCheck = {},
                        onUnCheck = {}
                    )
                    CheckListInputItem(
                        onCheck = { /*TODO*/ }
                    ) {

                    }
                }
            }
            Card {
                Text(
                    fontSize = 18.sp,
                    text = "출석")
                Column(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    CheckListItem(
                        checked = true,
                        content = "강민석",
                        onCheck = {},
                        onUnCheck = {}
                    )
                    CheckListItem(
                        checked = true,
                        content = "서정덕",
                        onCheck = {},
                        onUnCheck = {}
                    )
                }
            }
        }
    }
}