package com.afs.tutrd.component.input

import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.*
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
fun TutrdTimePicker(
    modifier: Modifier = Modifier,
    initialText: String = "시간" // Default placeholder text
) {
    val context = LocalContext.current
    var selectedTimeText by remember { mutableStateOf(initialText) }

    // Get the current time
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    // TimePickerDialog to select the time
    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
            selectedTimeText = String.format("%02d시 %02d분", selectedHour, selectedMinute) // Update with the selected time
        }, hour, minute, true // Use 24-hour format
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
                // Open the TimePicker when clicked
                timePickerDialog.show()
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
            text = selectedTimeText,
            fontSize = 16.sp,
            color = if (selectedTimeText == initialText) Color.Gray else Color.Black, // Placeholder color logic
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
