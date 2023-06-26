package com.example.strengthfit.page

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.strengthfit.stateModels.SignUpUIStates
import com.example.strengthfit.stateModels.SignUpUIStates.SignUpUIState

class SignUpStatePreviewProvider : PreviewParameterProvider<SignUpUIStates> {
    override val values: Sequence<SignUpUIStates>
        get() = sequenceOf(
            SignUpUIState(),
            SignUpUIStates.Failed,
            SignUpUIStates.Success("Email")
    )
}
