package sample.kanda.mvvm.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_main.*
import sample.kanda.mvvm.R
import sample.kanda.mvvm.detail.DetailActivity
import sample.kanda.mvvm.gone
import sample.kanda.mvvm.viewModelProvider
import sample.kanda.mvvm.visible

class HomeActivity : AppCompatActivity(), ClickListener {

    val kodein by LazyKodein(appKodein)
    val viewModel by viewModelProvider { kodein.instance<HomeViewModel>() }
    val action by lazy { Intent() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
    }

    override fun onResume() {
        super.onResume()
        viewModel
                .loadContacts()
                .let { manageState(it) }
    }

    private fun manageState(state: State) {
        when (state) {
            State.EmptyState -> {
                emptyState.visible()
                contactList.gone()
            }
            is State.ListContacts -> {
                contactList.visible()
                emptyState.gone()
                feedList(state.listContacts)
            }
        }
    }

    fun setUpViews() {
        val manager = LinearLayoutManager(this)
        contactList.apply {
            setHasFixedSize(true)
            layoutManager = manager
        }

        addContact.setOnClickListener {
            action.data = Uri.parse("app://open.register")
            startActivity(action)
        }
    }

    fun feedList(list: List<ContactRow>) {
        contactList.adapter = HomeAdapter(list, this)
    }

    override fun onClick(item: ContactRow) {
        DetailActivity
                .intentToDetail(item.id)
                .apply {
                    startActivity(this)
                }
    }
}
