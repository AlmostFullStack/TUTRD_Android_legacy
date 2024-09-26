package com.afs.tutrd.component.dropDown

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.afs.tutrd.R
import com.afs.tutrd.component.tooltip.noRippleClickable
import com.afs.tutrd.theme.MediumBody2
import com.afs.tutrd.theme.SystemBlack
import com.afs.tutrd.theme.SystemGrey3
import com.afs.tutrd.theme.SystemWhite


/**
 * 드롭다운 아이템 인터페이스
 *
 * [BasicDropDown] 에 들어갈 드롭다운 아이템에 해당 인터페이스를 상속해 주세요.
 *
 * @property title 드롭다운 아이템의 타이틀
 */
interface DropDownItem {
    val title: String
}

/**
 * 기본 드롭다운
 *
 * @param modifier [Modifier]
 * @param selectedItem 선택된 아이템
 * @param dropDownList 드롭다운 리스트
 * @param onSelected 선택 이벤트
 * @param T [DropDownItem]을 상속받은 클래스
 *
 * @sample BasicDropDownPreview
 *
 */

@Composable
fun <T> BasicDropDown(
    modifier: Modifier = Modifier,
    selectedItem: T,
    dropDownList: Array<T>,
    onSelected: (T) -> Unit
) where T: DropDownItem {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    var rowSize by remember { mutableStateOf(Size.Zero) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isDropDownMenuExpanded) -180f else 0f,
        label = "arrowIcon"
    )
    val borderColor by animateColorAsState(
        targetValue = if (isDropDownMenuExpanded) SystemBlack else SystemGrey3,
        label = "borderColor"
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned { layoutCoordinates ->
                rowSize = layoutCoordinates.size.toSize()
            }
    ) {
        Row(
            modifier = Modifier
                .height(44.dp)
                .border(1.dp, borderColor, CircleShape)
                .padding(horizontal = 20.dp)
                .noRippleClickable { isDropDownMenuExpanded = true },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = selectedItem.title,
                style = MediumBody2,
                color = SystemBlack,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Icon(
                modifier = Modifier.rotate(rotationAngle),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "arrowDown"
            )
        }
        DropdownMenu(
            modifier = Modifier
                .width(with(LocalDensity.current) { rowSize.width.toDp() })
                .heightIn(max = 260.dp),
            shape = RoundedCornerShape(16.dp),
            offset = DpOffset(x = 0.dp, y = 8.dp),
            containerColor = SystemWhite,
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false }
        ) {
            dropDownList.forEach {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = it.title,
                            style = MediumBody2,
                            color = SystemBlack
                        )
                    },
                    onClick = {
                        onSelected(it)
                        isDropDownMenuExpanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicDropDownPreview() {
    // 예시 데이터 클래스
    data class ExampleItem(override val title: String) : DropDownItem

    // 예시 리스트
    val dropDownList = arrayOf(ExampleItem("drop1"), ExampleItem("drop12"), ExampleItem("2321423423342"))

    // 선택 예시 - 뷰모델 State가 됩니다
    var selectedItem by remember { mutableStateOf(dropDownList[0]) }

    BasicDropDown(
        selectedItem = selectedItem,
        dropDownList = dropDownList,
        onSelected = { selectedItem = it }
    )
}