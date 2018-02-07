package sample.kanda.mvvm.home

import android.arch.lifecycle.Observer
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_main.*
import sample.kanda.mvvm.R
import sample.kanda.mvvm.gone
import sample.kanda.mvvm.viewModelProvider
import sample.kanda.mvvm.visible

class HomeActivity : AppCompatActivity() {
    val kodein by LazyKodein(appKodein)
    val viewModel by viewModelProvider { kodein.instance<HomeViewModel>() }
    val action by lazy { Intent() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.init()
        viewModel.liveData.observe(this, Observer { state ->
            state?.apply {
                manageState(this)
            }
        })
        addContact.setOnClickListener {
            action.data = Uri.parse("app://open.register")
            startActivity(action)
        }
    }

    private fun manageState(state: State) {
        when (state) {
            State.EmptyState -> {
                emptyState.visible()
                contactList.gone()
            }
        }
    }

}
