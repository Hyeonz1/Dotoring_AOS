package com.example.dotoring.dto.register

import java.io.File

data class registerRequest(
    val memberId: String,
    val password: String,
    val nickname: String,
    val employCertification: File,
    val graduationCertification: File,
    val introduction: String,
    val email: String
)
