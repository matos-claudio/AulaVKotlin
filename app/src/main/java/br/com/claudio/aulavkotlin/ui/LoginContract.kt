package br.com.claudio.aulavkotlin.ui

interface LoginContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showLoginSuccess(message: String)
        fun showLoginError(message: String)
    }

    interface Presenter {
        fun login(username: String, password: String)
    }
}