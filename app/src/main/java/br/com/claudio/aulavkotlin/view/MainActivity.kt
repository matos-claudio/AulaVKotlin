package br.com.claudio.aulavkotlin.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.claudio.aulavkotlin.databinding.ActivityMainBinding
import br.com.claudio.aulavkotlin.model.Model
import br.com.claudio.aulavkotlin.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, Model())
        binding.btGenerate.setOnClickListener {
            presenter.onButtonClick()
        }
    }

    override fun showProgress() {
        binding.progress.visibility = View.VISIBLE
        binding.tvName.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        binding.progress.visibility = View.GONE
        binding.tvName.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        binding.tvName.text = string
    }
}