package com.hamza.retofit_lab9.network

import com.hamza.retofit_lab9.models.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiCalls {

    @GET("/api/users?page=1")
    suspend fun getUsers ():Response<UserModel>
}