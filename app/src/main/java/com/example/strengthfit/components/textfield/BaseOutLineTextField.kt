package com.example.strengthfit.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseOutLineTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    isError: Boolean = false,
    hasFocus: Boolean,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    supportingText: @Composable () -> Unit = {},
) {


    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
            ),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = labelText)
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        isError = if (!hasFocus && value.isNotEmpty()) isError else false,
        supportingText = {
            if (!hasFocus && value.isNotEmpty()) {
                supportingText()
            }
        }
    )
}
