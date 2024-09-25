package com.afs.tutrd.component.modal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.R
import com.afs.tutrd.presentation.shared.view.addsession.AddSessionModalContents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseModalBottomSheet(
    title: String?,
    modalBottomSheetState: SheetState,
    onCloseModal: () -> Unit,
    content: @Composable () -> Unit
) {
    ModalBottomSheet(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp),
        containerColor = Color.White,
        sheetState = modalBottomSheetState,
        onDismissRequest = { onCloseModal() },
        dragHandle = { },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically  // Ensure vertical alignment for the text and button
            ) {
                Spacer(modifier = Modifier.width(28.dp))
                Spacer(modifier = Modifier.weight(1f))

                if (!title.isNullOrBlank()) {
                    Text(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = title,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                // Right Spacer to push the close button to the rightmost side
                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = { onCloseModal() },
                    modifier = Modifier
                        .size(size = 28.dp)
                        .align(Alignment.CenterVertically),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_close),
                        contentDescription = "close"
                    )
                }
            }
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewModal() {
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
//        confirmValueChange = { it == SheetValue.Hidden || it == SheetValue.PartiallyExpanded }
    )
    BaseModalBottomSheet(title = "Hello", modalBottomSheetState = modalBottomSheetState, onCloseModal = { /*TODO*/ }) {

    }
}