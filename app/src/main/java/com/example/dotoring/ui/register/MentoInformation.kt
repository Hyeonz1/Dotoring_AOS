package com.example.dotoring.ui.register

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
class MentoInformation(
    val company: String = "",
    val careerLevel: Int = 1,
    val job: String="",
    val major: String="",
    val employmentCertification: File?=null,
    val graduateCertification: File? = null,
    val nickname: String = "",
    val introduction: String = "",
    val loginId: String = "",
    val password: String = "",
    val email: String = ""
    ): Parcelable