package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.BlueBase
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.ui.theme.DividerColor
import com.example.composepractice.ui.theme.TextBase


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 24.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RememberMeScreen()
                }
            }
        }
    }
}

@Composable
fun RememberMeScreen() {
    val annotatedStringOne = buildAnnotatedString {
        append(stringResource(R.string.location_permission_description))
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Red)) {
            append(stringResource(R.string.why))
        }
    }

    val annotatedStringTwo = buildAnnotatedString {
        append(stringResource(R.string.notification_permission_description))
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Red)) {
            append(stringResource(id = R.string.why))
        }
    }

    Column(
        modifier = Modifier.padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = stringResource(R.string.permissions), fontSize = 19.sp, fontWeight = FontWeight.Bold)
        Divider(color = DividerColor, thickness = 2.dp)
        PermissionElement(
            text = annotatedStringOne,
            icon = R.drawable.location,
            buttonText = stringResource(R.string.give_permission)
        )
        PermissionElement(
            text = annotatedStringTwo,
            icon = R.drawable.notification,
            buttonText = stringResource(id = R.string.give_permission)
        )
        Text(
            textAlign = TextAlign.Center,
            color = Color.Red,
            fontSize = 15.sp,
            text = stringResource(R.string.subscribe_247)
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10),
            enabled = false,
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.next), fontSize = 15.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRememberMeScreen() {
    ComposePracticeTheme {
        RememberMeScreen()
    }
}

@Composable
fun PermissionElement(text: AnnotatedString, icon: Int, buttonText: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = text, fontSize = 15.sp, color = TextBase)
        Button(
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.size(40.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = BlueBase),
            shape = CircleShape
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = null)
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = BlueBase),
            shape = RoundedCornerShape(10),
            onClick = { /*TODO*/ }) {
            Text(text = buttonText, fontSize = 15.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPermissionElement() {
    ComposePracticeTheme {
        PermissionElement(
            buildAnnotatedString { append("Permission text") },
            R.drawable.notification,
            "Give permission"
        )
    }
}
