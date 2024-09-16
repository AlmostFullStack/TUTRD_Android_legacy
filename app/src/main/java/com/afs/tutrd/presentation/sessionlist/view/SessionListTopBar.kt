package com.afs.tutrd.presentation.sessionlist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afs.tutrd.R
import com.afs.tutrd.theme.Heading1
import com.afs.tutrd.theme.TutrdBackground

@Composable
internal fun SessionListTopBar(
    onClickTitle: () -> Unit,
    onAddSession: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(TutrdBackground)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            modifier = Modifier,
            text = "수업 목록",
            style = Heading1
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        IconButton(
            onClick = { onAddSession() },
            modifier = Modifier
                .size(28.dp),
            content = {
                Image(painter = painterResource(id =  R.drawable.add_session), contentDescription = "see more")
            }
        )
    }
}