package com.example.strengthfit.components.textfield

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.strengthfit.R

@Composable
fun SupportingErrorText(
    message: String
) {
    Text(
        text = message,
        color = Color.Red,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun PasswordOutLineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    leadingIcon: @Composable () -> Unit = {},
) {

    val showPassword = rememberSaveable() {
        mutableStateOf(false)
    }
    val hasFocused = rememberSaveable() {
        mutableStateOf(false)
    }

    BaseOutLineTextField(
        modifier = Modifier.onFocusChanged {
            hasFocused.value = it.isFocused
        },
        value = value,
        onValueChange = onValueChange,
        labelText = labelText,
        isError = isError,
        hasFocus = hasFocused.value,
        visualTransformation = if (showPassword.value) VisualTransformation.None else visualTransformation,
        leadingIcon = leadingIcon,
        trailingIcon = {
            showPasswordIconContent(
                showPasswordIcon = showPassword.value,
                onValueChange = { newValue ->
                    showPassword.value = newValue
                },
            )
        },
        supportingText = {
            if (!hasFocused.value && isError) {
                SupportingErrorText(message = "Password not long enough")
            }
        }
    )
}


@Composable
fun showPasswordIconContent(
    showPasswordIcon: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    val resourceId = when (showPasswordIcon) {
        true -> Pair(R.drawable.unhide_password_icon, "Show Password Icon")
        false -> Pair(R.drawable.hide_password_image, "Hide Password Icon")
    }
    Image(
        painter = painterResource(id = resourceId.first),
        contentDescription = resourceId.second,
        modifier = Modifier.clickable {
            onValueChange(!showPasswordIcon)
        },
    )
}

