package com.example.dotoring.ui.home

import com.example.dotoring.ui.home.data.Mentee

data class HomeUiState(
    val mentiList: List<Mentee> = listOf<Mentee> (),
    val majors: List<String> = listOf(),
    val jobs: List<String> = listOf()
)
