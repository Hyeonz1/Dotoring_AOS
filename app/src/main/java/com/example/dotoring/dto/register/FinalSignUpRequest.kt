package com.example.dotoring.dto.register

import java.io.File

data class FinalSignUpRequest(
    val certifications: List<File>,
    val mentoSignupRequestDTO: MentoSignupRequestDTO
)
