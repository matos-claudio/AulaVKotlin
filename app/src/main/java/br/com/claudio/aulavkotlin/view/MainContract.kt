package br.com.claudio.aulavkotlin.view

interface MainContract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun setString(string: String?)
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }
        fun getNextName(onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        fun onButtonClick()
    }
}