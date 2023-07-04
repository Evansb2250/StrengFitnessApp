package com.example.strengthfit.components.profileImage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.strengthfit.R


@Composable
fun ProfileImage(

) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = Color.Transparent,
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier,
            shape = CircleShape,
            content = {
                Image(
                    painter = painterResource(
                        R.drawable.profile_image,
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )
            }
        )
    }
}
