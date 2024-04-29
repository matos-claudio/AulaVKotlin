package br.com.claudio.aulavkotlin.ui

import br.com.claudio.aulavkotlin.data.LoginRepository

class LoginPresenter(
    private val view: LoginContract.View,
    private val repository: LoginRepository
): LoginContract.Presenter {
    override fun login(username: String, password: String) {
        view.showLoading()
        repository.login(username, password, object : LoginRepository.LoginCallback {
            override fun onSuccess(success: Boolean, message: String) {
                view.hideLoading()
                view.showLoginSuccess(message)
            }

            override fun onError(success: Boolean, message: String) {
                view.hideLoading()
                view.showLoginError(message)
            }
        })
    }
}