package com.example.dotoring.dto

import com.google.gson.JsonObject

data class CommonResponse(
    val success: Boolean,
    val response: JsonObject,
    val error: CommonErrorResponse
)
