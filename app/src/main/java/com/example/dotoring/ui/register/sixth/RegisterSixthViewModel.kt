package com.example.dotoring.ui.register.sixth

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.dto.register.EmailCertificationRequest
import com.example.dotoring.dto.register.EmailCodeRequest
import com.example.dotoring.dto.register.IdValidationRequest
import com.example.dotoring.network.DotoringAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterSixthViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(RegisterSixthUiState())
    val uiState: StateFlow<RegisterSixthUiState> = _uiState.asStateFlow()

    fun updateUserId(idInput: String) {
        _uiState.update { currentState ->
            currentState.copy(memberId = idInput)
        }
    }

    fun toggleErrorTextColor() {
        if( _uiState.value.idError ) {
            _uiState.update { currentState ->
                currentState.copy(idErrorTextColor = Color(0xffff7B7B))
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(idErrorTextColor = Color.Transparent)
            }
        }
    }

    fun updateUserPassword(passwordInput: String) {
        _uiState.update { currentState ->
            currentState.copy(password = passwordInput)
        }
    }

    fun updatePasswordCertification(pwCertificationInput: String) {
        _uiState.update { currentState ->
            currentState.copy(passwordCertification = pwCertificationInput)
        }
    }

    fun passwordErrorCheck() {
        if (_uiState.value.password == _uiState.value.passwordCertification) {
            _uiState.update { currentState ->
                currentState.copy(passwordCertified = true)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(passwordCertified = false)
            }
        }
        if( _uiState.value.passwordCertified ) {
            _uiState.update { currentState ->
                currentState.copy(passwordErrorTextColor = Color.Transparent)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(passwordErrorTextColor = Color(0xffff7B7B))
            }
        }
    }

    fun updateEmail(emailInput: String) {
        _uiState.update { currentState ->
            currentState.copy(email = emailInput)
        }
    }

    fun updateValidationCode (codeInput: String) {
        _uiState.update { currentState ->
            currentState.copy(validationCode = codeInput)
        }
    }

    fun toggleEmailErrorTextColor() {
        if( _uiState.value.emailValidated ) {
            _uiState.update { currentState ->
                currentState.copy(emailErrorTextColor = Color.Transparent)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(emailErrorTextColor = Color(0xffff7B7B))
            }
        }
    }

    fun updateBtnState () {
        _uiState.update { currentState ->
            currentState.copy(btnState = true)
        }
    }

    fun startTimer () {
        object : CountDownTimer(300000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val totalSeconds = millisUntilFinished / 1000
                val minutes = totalSeconds / 60
                val seconds = totalSeconds % 60
                val format = "$minutes:$seconds"

                _uiState.update { currentState ->
                    currentState.copy(certificationPeriod = format)
                }
            }

            override fun onFinish() {
                _uiState.update { currentState ->
                    currentState.copy(certificationPeriod = "시간 초과")
                }
            }
        }.start()
    }

    fun userIdDuplicationCheck() {
        val idValidationRequest = IdValidationRequest(loginId = uiState.value.memberId)
        val idValidationRequestCall: Call<CommonResponse> = DotoringAPI.retrofitService.loginIdValidation(idValidationRequest)

        idValidationRequestCall.enqueue(object: Callback<CommonResponse> {
            override fun onResponse(call: Call<CommonResponse>, response: Response<CommonResponse>) {

                val jsonObjectResponse = JSONObject(response.body().toString())
                val jsonObjectSuccess = jsonObjectResponse.getBoolean("success")

                if (jsonObjectSuccess) {
                    _uiState.update { currentState ->
                        currentState.copy(idAvailable = true)
                    }
                }
            }
            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("회원 가입 통신", "요청 내용 - $idValidationRequestCall")
            }
        })
    }

    fun sendAuthenticationCode() {
        val authenticationCodeRequest = EmailCodeRequest(email = uiState.value.email)
        val authenticationCodeRequestCall: Call<CommonResponse> = DotoringAPI.retrofitService.sendAuthenticationCode(authenticationCodeRequest)

        authenticationCodeRequestCall.enqueue(object: Callback<CommonResponse> {
            override fun onResponse(call: Call<CommonResponse>, response: Response<CommonResponse>) {

                /*val jsonObjectResponse = JSONObject(response.body().toString())
                val jsonObjectSuccess = jsonObjectResponse.getBoolean("success")

                if (jsonObjectSuccess) {

                }*/
            }
            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("회원 가입 통신", "요청 내용 - $authenticationCodeRequestCall")
            }
        })
    }

    fun codeCertification() {
        val codeCertificationRequest = EmailCertificationRequest(code = uiState.value.validationCode)
        val codeCertificationRequestCall: Call<CommonResponse> = DotoringAPI.retrofitService.emailCertification(codeCertificationRequest)

        codeCertificationRequestCall.enqueue(object: Callback<CommonResponse> {
            override fun onResponse(call: Call<CommonResponse>, response: Response<CommonResponse>) {

                val jsonObjectResponse = JSONObject(response.body().toString())
                val jsonObjectSuccess = jsonObjectResponse.getBoolean("success")

                if (jsonObjectSuccess) {
                    _uiState.update { currentState ->
                        currentState.copy(emailValidated = true)
                    }

                    toggleEmailErrorTextColor()
                    updateBtnState()

                }
            }
            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("회원 가입 통신", "요청 내용 - $codeCertificationRequestCall")
            }
        })
    }
}