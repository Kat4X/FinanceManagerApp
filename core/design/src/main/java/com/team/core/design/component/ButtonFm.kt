package com.team.core.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team.core.design.theme.StellarisTheme
import com.team.core.design.theme.defaultButtonShape

@Composable
fun ButtonFm(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.bounceClick(),
        shape = defaultButtonShape,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewButtonFm() {
    StellarisTheme {
        BoxWithConstraints(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            ButtonFm(text = "Кнопка") {}
        }
    }
}
