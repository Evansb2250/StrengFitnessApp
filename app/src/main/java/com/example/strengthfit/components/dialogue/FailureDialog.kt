package com.example.strengthfit.components.dialogue

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.strengthfit.R
import com.example.strengthfit.components.CustomOutLineButton

@Composable
fun FailureDialog(
    onCancel:() -> Unit = {},
    onRetry: () -> Unit = {},
){
    CustomBaseDialog(
        onDismiss = onCancel,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 20.dp
                )
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Failed Sign-Up Attemp",
                    textAlign = TextAlign.Center,
                )
                Spacer(
                    modifier = Modifier.size(
                        50.dp,
                    )
                )

                Image(
                    painter = painterResource(
                        id = R.drawable.failure_icon,
                    ),
                    contentDescription = "Failed Sign-in",
                )

                CustomOutLineButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = onCancel,
                    buttonText = "Cancel",
                )

                CustomOutLineButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = onRetry,
                    buttonText = "Retry",
                )

                Spacer(
                    modifier = Modifier.size(
                        50.dp,
                    )
                )
            }
        }
    )
}