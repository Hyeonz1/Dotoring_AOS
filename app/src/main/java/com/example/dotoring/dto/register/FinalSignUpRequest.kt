package com.example.dotoring.dto.register

import okhttp3.MultipartBody

data class FinalSignUpRequest(
    val certifications: List<MultipartBody.Part?>,
    val mentoSignupRequestDTO: MentoSignupRequestDTO
)
