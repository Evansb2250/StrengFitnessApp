package com.example.strengthfit.components.dialogue

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.strengthfit.R

@Composable
fun SuccessDialog(
    onDismiss:() -> Unit = {},
){
    CustomBaseDialog(
        onDismiss = onDismiss,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Success",
                    textAlign = TextAlign.Center,
                )
                Spacer(
                    modifier = Modifier.size(
                        50.dp,
                    )
                )

                Image(
                    painter = painterResource(
                        id = R.drawable.success_tic,
                    ),
                    contentDescription = "Success Image",
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            40.dp,
                        ),
                    onClick = onDismiss,
                ) {
                    Text(
                        text = "Click Me"
                    )
                }
            }
        }
    )
}