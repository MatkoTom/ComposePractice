package com.example.composepractice.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BorderPractice() {
    Box(
        modifier = Modifier
            .width(400.dp)
            .height(400.dp)
            .background(Color.Green)
            .border(width = 8.dp, color = Color.Red)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 8.dp)
                .border(width = 8.dp, color = Color.Blue)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 16.dp)
                    .background(Color.Black)
                    .border(width = 8.dp, color = Color.White)
            ) {
                val text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Red, fontSize = 16.sp)) {
                        append("T")
                    }
                    append("est ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("T")
                    }
                    append("ext")
                }
                Text(
                    text = text,
                    color = Color.White,
                    modifier = Modifier
                        .padding(all = 16.dp)
                        .border(width = 2.dp, color = Color.Yellow)
                        .padding(all = 8.dp)
                        .offset(x = 16.dp, y = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BorderPracticePreview() {
    BorderPractice()
}
