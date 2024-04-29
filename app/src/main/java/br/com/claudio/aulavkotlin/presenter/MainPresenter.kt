package br.com.claudio.aulavkotlin.presenter

import br.com.claudio.aulavkotlin.view.MainContract

class MainPresenter(
    private var mainView: MainContract.View,
    private var model: MainContract.Model
) : MainContract.Presenter, MainContract.Model.OnFinishedListener {
    override fun onFinished(string: String?) {
        mainView.setString(string)
        mainView.hideProgress()
    }

    override fun onButtonClick() {
        mainView.showProgress()
        model.getNextName(this)
    }

}