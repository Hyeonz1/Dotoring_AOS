package com.example.dotoring.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.network.DotoringAPI
import com.example.dotoring.ui.home.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MentiDetailedViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MentiDetailedUiState())
    val uiState: StateFlow<MentiDetailedUiState> = _uiState.asStateFlow()

    fun loadMentiInfo(profileImage: Int?, nickname: String?, job: String?, major: String?, introduction: String?) {
        Log.d("업데이트", "loadMentiInfo 실행")
        _uiState.update { currentState ->
            currentState.copy( profileImage = profileImage, nickname= nickname, job = job, major = major, introduction = introduction)
        }
        Log.d("업데이트", "넣은 값: ${nickname} uiState: ${uiState.value.nickname}")

    }
   /* fun loadMenteeInfo() {
        val loadMenteeInfoRequestCall: Call<CommonResponse> = DotoringAPI.retrofitService.loadMentiDetailedInfo(id = uiState.value.id)

        loadMenteeInfoRequestCall.enqueue(object: Callback<CommonResponse> {
            override fun onResponse(call: Call<CommonResponse>, response: Response<CommonResponse>) {

                val jsonObjectResponse = JSONObject(response.body().toString())
                val jsonObjectSuccess = jsonObjectResponse.getBoolean("success")
                val jsonObjectResult = jsonObjectResponse.getJSONObject("response")

                val profileImage = jsonObjectResult.getString("profileImage")
                val nickname = jsonObjectResult.getString("nickname")
                val job = jsonObjectResult.getString("job")
                val major = jsonObjectResult.getString("major")
                val introduction = jsonObjectResult.getString("introduction")

                if (jsonObjectSuccess) {
                    _uiState.update { currentState ->
                        currentState.copy(
                            profileImage = profileImage,
                            nickname = nickname,
                            job = job,
                            major = major,
                            introduction = introduction
                        )
                    }
                }
            }
            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("회원 가입 통신", "요청 내용 - $loadMenteeInfoRequestCall")
            }
        })
    }*/
}