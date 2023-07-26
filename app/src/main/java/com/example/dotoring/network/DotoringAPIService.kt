package com.example.dotoring.network

import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.dto.login.LoginRequest
import com.example.dotoring.dto.message.MessageRequest
import com.example.dotoring.dto.register.EmailCertificationRequest
import com.example.dotoring.dto.register.EmailCodeRequest
import com.example.dotoring.dto.register.FinalSignUpRequest
import com.example.dotoring.dto.register.IdValidationRequest
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
    "http://192.168.0.9:8080/"

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
        @Body loginValidationRequest: IdValidationRequest
    ): Call<CommonResponse>

    @GET("api/member/email")
    fun sendAuthenticationCode(
        @Body emailCodeRequest: EmailCodeRequest
    ): Call<CommonResponse>

    @POST("api/member/validate-code")
    fun emailCertification(
        @Body emailCertificationRequest: EmailCertificationRequest
    ): Call<CommonResponse>

    @GET("api/member/job-major")
    fun getJobAndMajorList(): Call<CommonResponse>

    @POST("api/signup-mento")
    fun signUpAsMento(
        @Body finalSignUpRequest: FinalSignUpRequest
    ):Call <CommonResponse>

    @GET("api/menti")
    fun searchMentee(
    ): Call<CommonResponse>

    @GET("api/menti")
    fun searchMenteeWithMajors(
        @Query("majors") majors: String
    ): Call<CommonResponse>

    @GET("api/menti")
    fun searchMenteeWithJobs(
        @Query("jobs") jobs: String
    ): Call<CommonResponse>

    @GET("api/menti")
    fun searchMenteeWithAllFilter(
        @Query("majors") majors: String,
        @Query("jobs") jobs: String
    ): Call<CommonResponse>

    @GET("api/mento/{id}")
    fun loadDMentoDetailedInfo(
        @Path("id") userId: String
    ): Call<CommonResponse>

    @GET("api/menti/{id}")
    fun loadMentiDetailedInfo(
        @Path("id") mentiId: Int
    ): Call<CommonResponse>

    @POST("api/auth/login")
    fun doLogin(
        @Body loginRequest: LoginRequest
    ): Call<CommonResponse>

    @POST("api/auth/reissue")
    fun reissue(
    ): Call<CommonResponse>

    @POST("api/mento/letter/in/{mentiid}")
    fun inSendMessage(
        @Body MessageRequest: MessageRequest
    ): Call<CommonResponse>

    @POST("api/mento/letter/out/{mentiid}")
    fun outSendMessage(
        @Body MessageRequest: MessageRequest
    ): Call<CommonResponse>

    @GET("api/mento/room")
    fun loadMessageBox(
    ): Call<CommonResponse>

    @GET("api/mento/letter/{roomPk}")
    fun loadDetailedMessage(
        @Path("roomPk") roomPk: Int,
        @Query("page") page: Int,
        @Query("size") size: Int

    ): Call<CommonResponse>



}




object DotoringAPI {
    val retrofitService: DotoringAPIService by lazy {
        retrofit.create(DotoringAPIService::class.java)
    }
}