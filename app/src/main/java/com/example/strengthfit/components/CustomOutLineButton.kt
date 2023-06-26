package com.example.strengthfit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomOutLineButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonText: String,
    enable: Boolean = true
){
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        onClick = onClick,
        enabled = enable,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
        ),
    ) {
        Text(text = buttonText)
    }
}