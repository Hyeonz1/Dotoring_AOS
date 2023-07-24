package com.example.dotoring.dto.register

data class MentoSignupRequestDTO(
    val company: String,
    val careerLevel: Int,
    val job: String,
    val major: String,
    val nickname: String,
    val introduction: String,
    val loginId: String,
    val password: String,
    val email: String
)
