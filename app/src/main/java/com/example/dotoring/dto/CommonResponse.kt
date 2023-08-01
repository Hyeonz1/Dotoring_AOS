package com.example.dotoring.dto

import com.google.gson.JsonElement

data class CommonResponse(
    val success: Boolean,
    val response: JsonElement?,
    val error: CommonErrorResponse
)
