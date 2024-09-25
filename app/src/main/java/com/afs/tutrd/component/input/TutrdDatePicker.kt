package com.afs.tutrd.component.input

import androidx.compose.runtime.Composable
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.R
import com.afs.tutrd.theme.CheckBox_Unchecked
import java.util.*

@Composable
fun TutrdDatePicker(
    modifier: Modifier = Modifier,
    initialText: String = "날짜" // Default placeholder text
) {
    val context = LocalContext.current
    var selectedDateText by remember { mutableStateOf(initialText) }

    // Get the current date
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // DatePickerDialog to select the date
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            selectedDateText = "$selectedYear-${selectedMonth + 1}-$selectedDay" // Update with the selected date
        }, year, month, day
    )

    Row(
        modifier = modifier
            .height(44.dp)
            .border(
                width = 1.dp,
                color = CheckBox_Unchecked, // Light grey border
                shape = RoundedCornerShape(22.dp) // Rounded edges like in the image
            )
            .padding(horizontal = 20.dp)
            .clickable {
                // Open the DatePicker when clicked
                datePickerDialog.show()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_search), // Replace with your search icon
            contentDescription = "Search Icon",
            modifier = Modifier.size(20.dp),
            tint = Color.Black // Set the icon color
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = selectedDateText,
            fontSize = 16.sp,
            color = if (selectedDateText == initialText) Color.Gray else Color.Black, // Placeholder color logic
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}