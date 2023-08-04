package com.example.dotoring.dto.register

data class EmailCertificationRequest(
    val emailVerificationCode: String,
    val email: String
)
