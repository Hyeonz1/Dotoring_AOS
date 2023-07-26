package com.example.dotoring.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.network.DotoringAPI
import com.example.dotoring.ui.home.data.Mentee
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun loadMentiList() {
        val mentiListRequestCall: Call<CommonResponse> = DotoringAPI.retrofitService.searchMentee()

        mentiListRequestCall.enqueue(object: Callback<CommonResponse> {
            override fun onResponse(call: Call<CommonResponse>, response: Response<CommonResponse>) {

                val jsonObjectResponse = JSONObject(response.body().toString())
                val jsonObjectSuccess = jsonObjectResponse.getBoolean("success")
                val jsonObjectSuccessResponse = jsonObjectResponse.getJSONObject("response")
                val mentiList = jsonObjectSuccessResponse.getJSONArray("content")

                val uiMentiList: MutableList<Mentee> = mutableListOf()

                if (jsonObjectSuccess && mentiList.length() > 0) {
                    for (i in 0 until mentiList.length()){
                        Log.d("멘티리스트 가져오기"+ " i", i.toString())
                        val getObject = mentiList.getJSONObject(i)

                        val menti = Mentee(
                            nickname = getObject.getString("nickname"),
                            profileImage = getObject.getString("profileImage"),
                            major = getObject.getString("major"),
                            introduction = getObject.getString("introduction")
                        )

                        uiMentiList.add(menti)
                    }

                    _uiState.update { currentState ->
                        currentState.copy(mentiList = uiMentiList)
                    }
                }
            }
            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("회원 가입 통신", "요청 내용 - $mentiListRequestCall")
            }
        })
    }



}
