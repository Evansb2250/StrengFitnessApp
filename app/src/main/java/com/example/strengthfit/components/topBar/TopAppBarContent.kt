package com.example.strengthfit.components.topBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.strengthfit.components.profileImage.ProfileImage
import com.example.strengthfit.constants.appTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(
    openDrawer: () -> Unit,
) {
    BaseTopBar(
        title = {
            Text(
                text = appTitle,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    openDrawer()
                }
            ) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Drawer Icon")
            }
        },
        actions = {
            ProfileImage()
        }
    )
}
