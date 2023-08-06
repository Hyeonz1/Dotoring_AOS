package com.example.dotoring.ui.register.first

data class RegisterFirstUiState(
    val company: String = "",
    val fillCompanyField: Boolean = false,

    val careerLevel: String = "",
    val fillCareerField: Boolean = false,

    val job: String = "",
    val fillJobField: Boolean = false,

    val major: String = "",
    val fillMajorField: Boolean = false,

    val firstBtnState: Boolean = false
)
