package com.example.dotoring.ui.register

import java.io.File

data class RegisterUiState(
    val company: String = "",
    val careerLevel: String = "",
    val job: String = "",
    val major: String = "",
    val employmentCertification: File? = null,
    val graduationCertification: File? = null,
    val nickname: String = "",
    val introduction: String = "",
    val acceptance: Boolean = false,
    val memberId: String = "",
    val password: String = "",
    val passwordCertification: String = "",
    val email: String = "",
    val validationCode: String = ""
    )
