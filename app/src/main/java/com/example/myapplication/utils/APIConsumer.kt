package com.example.myapplication.utils

import com.example.myapplication.model.UserData
import retrofit2.Call
import retrofit2.http.POST

interface APIConsumer {

    @POST("posts")
    fun sendUserData(
        userData: UserData
    ): Call<UserData>
}