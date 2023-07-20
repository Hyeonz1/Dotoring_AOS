package com.example.dotoring.network

import com.example.dotoring.dto.register.docsCertificationRequest
import com.example.dotoring.dto.register.docsCertificationResponse
import com.example.dotoring.dto.register.emailCertificationRequest
import com.example.dotoring.dto.register.emailCertificationResponse
import com.example.dotoring.dto.register.loginIdCertificationRequest
import com.example.dotoring.dto.register.loginIdCertificationResponse
import com.example.dotoring.dto.register.nicknameCertificationRequest
import com.example.dotoring.dto.register.nicknameCertificationResponse
import com.example.dotoring.dto.register.registerRequest
import com.example.dotoring.dto.register.registerResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
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
    @POST("api/certifications")
    fun docsCertification(
        @Body docsCertificationRequest: docsCertificationRequest
    ): Call<docsCertificationResponse>

    @POST("api/member/nickname")
    fun nicknameCertification(
        @Body nicknameCertificationRequest: nicknameCertificationRequest
    ): Call<nicknameCertificationResponse>

    @POST("api/member/loginId")
    fun loginIdCertification(
        @Body loginIdCertificationRequest: loginIdCertificationRequest
    ): Call<loginIdCertificationResponse>

    @POST("api/member/email")
    fun emailCertification(
        @Body emailCertificationRequest: emailCertificationRequest
    ): Call<emailCertificationResponse>

    @POST("api/mento")
    fun requestRegister(
        @Body requestRegisterRequest: registerRequest
    ): Call<registerResponse>
}


object DotoringAPI {
    val retrofitService: DotoringAPIService by lazy {
        retrofit.create(DotoringAPIService::class.java)
    }
}