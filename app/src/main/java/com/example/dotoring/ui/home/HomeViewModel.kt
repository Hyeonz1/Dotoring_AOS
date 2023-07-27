package com.example.dotoring.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.network.DotoringAPI
import com.example.dotoring.ui.home.data.Mentee
import com.google.gson.Gson
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
        DotoringAPI.retrofitService.searchMentee()
            .enqueue(object : Callback<CommonResponse> {
                override fun onResponse(call: Call<CommonResponse>, response: Response<CommonResponse>) {
                    val commonResponse = response.body()

                    if (commonResponse != null && commonResponse.success) {
                        val responseJsonObject = commonResponse.response

                        val mentiList = responseJsonObject?.optJSONArray("content")

                        if (mentiList != null && mentiList.length() > 0) {
                            val uiMentiList: MutableList<Mentee> = mutableListOf()

                            for (i in 0 until mentiList.length()) {
                                val mentiObject = mentiList.optJSONObject(i)

                                val mentee = Mentee(
                                    id = mentiObject.getLong("id"),
                                    nickname = mentiObject.getString("nickname"),
                                    profileImage = mentiObject.getString("profileImage"),
                                    major = mentiObject.getString("major"),
                                    job = mentiObject.getString("job"),
                                    introduction = mentiObject.getString("introduction")
                                )

                                uiMentiList.add(mentee)
                            }

                            _uiState.update { currentState ->
                                currentState.copy(mentiList = uiMentiList)
                            }
                        }
                    } else {
                        Log.d("통신", "응답이 실패하거나 데이터가 없습니다.")
                    }
                }

                override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                    Log.d("통신", "통신 실패: $t")
                }
            })
    }
}