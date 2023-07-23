package com.example.dotoring.network

import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.dto.register.EmailCertificationRequest
import com.example.dotoring.dto.register.FinalSignUpRequest
import com.example.dotoring.dto.register.LoginIdValidationRequest
import com.example.dotoring.dto.register.NicknameValidationRequest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.net.CookieManager

private const val BASE_URL =
    "http://192.168.0.110:8080/"

val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .cookieJar(JavaNetCookieJar(CookieManager()))
    .build()

val gson : Gson = GsonBuilder()
    .setLenient()
    .create()

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .client(client)
    .build()


interface DotoringAPIService {

    @POST("api/member/validate-nickname")
    fun nicknameValidation(
        @Body nicknameValidationRequest: NicknameValidationRequest
    ): Call<CommonResponse>

    @POST("api/member/validate-loginId")
    fun loginIdValidation(
        @Body loginValidationRequest: LoginIdValidationRequest
    ): Call<CommonResponse>

    @GET("api/member/email")
    fun emailCertification(
        @Body emailCertificationRequest: EmailCertificationRequest
    ): Call<CommonResponse>

    @GET("api/member/job-major")
    fun getJobAndMajorList(): Call<CommonResponse>

    @POST("api/signup-mento")
    fun signUpAsMento(
        @Body finalSignUpRequest: FinalSignUpRequest
    ):Call <CommonResponse>

    @GET("api/mento")
    fun searchMentee(
        @Query("majors") majors: String,
        @Query("jobs") jobs: String
    ): Call<CommonResponse>

    @GET("api/mento/{id}")
    fun loadDetailedInfo(
        @Path("id") userId: String
    ): Call<CommonResponse>
}


object DotoringAPI {
    val retrofitService: DotoringAPIService by lazy {
        retrofit.create(DotoringAPIService::class.java)
    }
}