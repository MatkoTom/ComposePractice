package com.example.composepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.theme.ComposePracticeTheme

@Composable
fun RotamapTopBar(
    title: String,
    firstItemIcon: ImageVector?,
    secondItemIcon: ImageVector?
) {
    Surface {
        Row(
            Modifier
                .background(color = MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.titleLarge, color = Color.White)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                Modifier.padding(top = 4.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))
            if (firstItemIcon != null) {
                Icon(
                    imageVector = firstItemIcon,
                    contentDescription = null,
                    modifier = Modifier.padding(top = 4.dp),
                    tint = Color.White
                )
            }
            if (secondItemIcon != null) {
                Icon(
                    imageVector = secondItemIcon,
                    contentDescription = null,
                    modifier = Modifier.padding(top = 4.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun RotamapTopBarPreview() {
    ComposePracticeTheme {
        RotamapTopBar(
            title = "my rota",
            firstItemIcon = Icons.Filled.AddCircleOutline,
            secondItemIcon = Icons.Filled.RemoveCircle
        )
    }
}
