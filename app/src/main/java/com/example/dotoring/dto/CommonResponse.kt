package com.example.dotoring.dto

import org.json.JSONObject

data class CommonResponse(
    val success: Boolean,
    val response: JSONObject?,
    val error: CommonErrorResponse
)
