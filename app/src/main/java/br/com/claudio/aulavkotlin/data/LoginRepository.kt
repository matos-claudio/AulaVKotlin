package br.com.claudio.aulavkotlin.data

import br.com.claudio.aulavkotlin.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository (private val apiService: ApiService) {

    fun login(username: String, password: String, callback: LoginCallback) {
        apiService.login(username, password).enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if(loginResponse != null) {
                        callback.onSuccess(loginResponse.success, loginResponse.message)
                    }
                } else {
                    callback.onError(false, "Erro ao realizar login!!!\nVerifique suas credenciais")
                }
            }

            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                callback.onError(false, "Erro de conexão: ${t.message}")
            }
        })
    }

    interface LoginCallback {
        fun onSuccess(success: Boolean, message: String)
        fun onError(success: Boolean, message: String)
    }
}