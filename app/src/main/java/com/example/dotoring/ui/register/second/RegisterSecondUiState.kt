package com.example.dotoring.ui.register.second

import java.io.File

data class RegisterSecondUiState(
    val employmentCertification: File? = null,
    val employmentFileUploaded: Boolean = false,
    val graduationCertification: File? = null,
    val graduationFileUploaded: Boolean = false
)
