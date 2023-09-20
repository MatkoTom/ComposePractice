package com.example.composepractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val buttonTexts: List<Int> = listOf(
    R.string.call, R.string.send_in_app_message, R.string.send_sms, R.string.copy_number
)

@Composable
fun ContactButtonsList(textItems: List<Int>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.persons_name),
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(textItems) { text ->
                ContactButton(onClick = { /*TODO*/ }, buttonText = text)
            }
        }
    }
}

@Composable
fun ContactButton(onClick: () -> Unit, buttonText: Int) {
    Surface {
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .padding(0.dp)
                .height(52.dp)
                .width(358.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(22.dp)
        ) {
            Text(text = stringResource(id = buttonText))
        }
    }
}

@Preview
@Composable
fun ContactButtonsListPreview() {
    ContactButtonsList(buttonTexts)
}

@Preview
@Composable
fun ContactButtonPreview() {
    ContactButton(onClick = { }, buttonText = R.string.call)
}
