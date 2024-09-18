package com.afs.tutrd.component.bottomBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.datastore.dataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.preferencesDataStoreFile
import com.afs.tutrd.common.datastore.TUTEE
import com.afs.tutrd.common.datastore.TUTOR
import com.afs.tutrd.common.datastore.TutrdRoleDataStore
import com.afs.tutrd.navigation.controller.BottomMenuTabs

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    current: BottomMenuTabs?,
    onClick: (BottomMenuTabs) -> Unit
) {
    val context = LocalContext.current
    val dataStore = TutrdRoleDataStore(context)
    val tutrdRole = dataStore.getTutrdRole.collectAsState(initial = TUTEE)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(Color(0xFFEEFCF2)) //FIXME DIVIDER 임시
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomMenuTabs.entries.forEach { item ->
            if(tutrdRole.value == TUTEE && item == BottomMenuTabs.PAY) Unit
//            else if(item == BottomMenuTabs.SESSION) Unit
            else {
                BottomBarItem(
                    modifier = Modifier.weight(1f),
                    iconId = item.iconId,
                    label = item.label,
                    selected = item == current,
                    onClick = { onClick(item) },
                )
            }
        }
    }
}

@Composable
private fun BottomBarItem(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .selectable(
                selected = selected,
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = iconId),
            tint = if (selected) Color.Black else Color.LightGray, // FIXME
            contentDescription = label,
        )
        Text(text = label)
    }

}