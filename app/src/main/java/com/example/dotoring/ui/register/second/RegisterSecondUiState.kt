package com.example.dotoring.ui.register.second

import android.net.Uri

data class RegisterSecondUiState(
    val employmentCertification: Uri? = null,
    val employmentFileUploaded: Boolean = false,
    val graduationCertification: Uri? = null,
    val graduationFileUploaded: Boolean = false
)
