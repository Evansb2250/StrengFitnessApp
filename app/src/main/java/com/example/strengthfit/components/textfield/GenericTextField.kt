package com.example.strengthfit.components.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GenericTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    isError: Boolean = false,
    errorMessage: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
){

    val hasFocused = rememberSaveable() {
        mutableStateOf(false)
    }

    BaseOutLineTextField(
        modifier = modifier.onFocusChanged {
            hasFocused.value = it.isFocused
        },
        value = value,
        onValueChange = onValueChange,
        labelText = labelText,
        isError = if (!hasFocused.value && value.isNotEmpty()) isError else false,
        hasFocus = hasFocused.value,
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = {
            if(!hasFocused.value && isError){
                SupportingErrorText(message = errorMessage)
            }
        }
    )
}