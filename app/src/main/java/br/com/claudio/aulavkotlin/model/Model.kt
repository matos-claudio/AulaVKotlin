package br.com.claudio.aulavkotlin.model

import android.os.Handler
import android.os.Looper
import br.com.claudio.aulavkotlin.view.MainContract
import java.util.Arrays
import java.util.Random

class Model : MainContract.Model {

    private val namesList = Arrays.asList(
        "Ana",
        "Maria",
        "Rogério",
        "Allan",
        "Victor",
        "Bruno",
        "Breno"
    )

    override fun getNextName(onFinishedListener: MainContract.Model.OnFinishedListener?) {
        Handler(Looper.getMainLooper()).postDelayed({
            onFinishedListener!!.onFinished(
                getRandomString
            )
        }, 1200)
    }

    private val getRandomString: String
        get() {
            val random = Random()
            val index = random.nextInt(namesList.size)
            return namesList[index]
        }
}