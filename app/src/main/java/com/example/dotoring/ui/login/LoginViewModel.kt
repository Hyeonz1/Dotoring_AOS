package com.example.dotoring.ui.login


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dotoring.MyApplication
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.dto.login.LoginRequest
import com.example.dotoring.navigation.Graph
import com.example.dotoring.navigation.HomeNavGraph
import com.example.dotoring.network.DotoringAPI
import com.example.dotoring.ui.home.HomeScreen
import com.example.dotoring.ui.login.data.TokenSharedPreferences
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()


    fun updateId(idInput: String) {
        _uiState.update { currentState ->
            currentState.copy(id = idInput)
        }
    }
    fun updatePwd(pwdInput: String) {
        _uiState.update { currentState ->
            currentState.copy(pwd = pwdInput)
        }
    }

    fun updateBtnState () {
        if ( uiState.value.id =="" || uiState.value.pwd=="")
        {
            _uiState.update { currentState ->
                currentState.copy(btnState = false)
            }
        }
        else{
            _uiState.update { currentState ->
                currentState.copy(btnState = true)
            }
        }
    }


    fun sendLogin(navController: NavHostController) {
        //navController.navigate(Graph.HOME)
        val sendLoginRequest= LoginRequest(loginId = uiState.value.id, password = uiState.value.pwd)
        val sendLoginRequestCall: Call<CommonResponse> = DotoringAPI.retrofitService.doLogin(sendLoginRequest)
        Log.d("통신", "ㅌ통신함수 실행:")

        sendLoginRequestCall.enqueue(object : Callback<CommonResponse>
        {


            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                Log.d("로그인", "통신 성공 : ${response.raw()}")
                Log.d("로그인", "통신 성공 : " + response.body().toString())
                val jsonObject= Gson().toJson(response.body())
                Log.d("로그인", "로그인??" +jsonObject)
                val jo = JSONObject(jsonObject)
                Log.d("f로그인","로그인 성공할락말락")
                val jsonObjectSuccess = jo.getBoolean("success")
                Log.d("통신", "ㅌ통신성공??:")

                if (jsonObjectSuccess) {
                    Log.d("통신", "ㅌ통신함수 성공:")
                    val accessToken= response.headers()["Authorization"]
                    val refreshToken= response.headers()["set-cookie"]
                    MyApplication.token_prefs.accessToken = accessToken
                    MyApplication.token_prefs.refreshToken = refreshToken

                    navController.navigate(Graph.HOME)
                }
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("회원 가입 통신", "요청 내용 - $sendLoginRequestCall")

            }
        })

    }


}