package br.com.claudio.aulavkotlin.network

import br.com.claudio.aulavkotlin.data.LoginResponseModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("auth")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponseModel>
}

