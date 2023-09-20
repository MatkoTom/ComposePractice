package com.example.composepractice

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

var selectedValue:MutableState<Int> = mutableStateOf(R.string.sms)

@Composable
fun PickerSelector(selected: Int) {
    Surface {
        var expanded by remember { mutableStateOf(false) }
        var selectedItem by remember {
            mutableStateOf(selected)
        }

        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .clickable { expanded = !expanded }
        ) {
            PickerTitleBar(text = R.string.label, selectedItem = selectedItem)
            if (expanded) {
                PickerContent(selectedItem)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PickerSelectorPreview() {
    PickerSelector(selected = R.string.sms)
}

@Composable
fun PickerTitleBar(text: Int, selectedItem: Int) {
    Row(
        modifier = Modifier.padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = text), style = MaterialTheme.typography.titleSmall)

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = selectedItem),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(end = 4.dp)
        )
        Icon(
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PickerTitleBarPreview() {
    PickerTitleBar(text = R.string.label, selectedItem = R.string.sms)
}

val pickerItems: List<Int> = listOf(
    R.string.push,
    R.string.sms,
    R.string.email,
    R.string.none
)

@Composable
fun PickerContent(topLabel: Int) {
    LazyColumn(
        modifier = Modifier.padding(top = 32.dp, bottom = 32.dp, start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(pickerItems) { item ->
            PickerContentItem(text = item, item == topLabel)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PickerContentPreview() {
    PickerContent(R.string.label)
}

@Composable
fun PickerContentItem(text: Int, selected: Boolean) {
    var itemSelected by remember { mutableStateOf(selected) }
    val backgroundValue =
        if (itemSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background

    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(backgroundValue)
            .padding(12.dp)
            .fillMaxWidth()
            .clickable { selectedValue.value = text}
    )
}

@Composable
@Preview(showBackground = true)
fun PickerContentItemPreview() {
    PickerContentItem(text = R.string.push, true)
}