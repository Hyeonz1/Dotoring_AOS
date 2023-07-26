package com.example.dotoring.ui.home.data

class DataSource {
    fun loadMenties(): List<Mentee> {
        return listOf<Mentee>(
            Mentee(nickname = "현지", profileImage = "...", major = "소프트웨어공학과", job="dd", introduction = "하이"),
            Mentee(nickname = "현지", profileImage = "...", major = "소프트웨어공학과", job="dd",introduction = "하이"),
            Mentee(nickname = "현지", profileImage = "...", major = "소프트웨어공학과", job="dd",introduction = "하이"),
            Mentee(nickname = "현지", profileImage = "...", major = "소프트웨어공학과", job="dd",introduction = "하이")
        )
    }
}