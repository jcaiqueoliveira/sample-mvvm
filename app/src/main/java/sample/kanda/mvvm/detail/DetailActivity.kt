package sample.kanda.mvvm.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_detail.*
import sample.kanda.domain.Label
import sample.kanda.mvvm.R
import sample.kanda.mvvm.toast
import sample.kanda.mvvm.viewModelProvider

class DetailActivity : AppCompatActivity() {
    val kodein by LazyKodein(appKodein)
    private val viewModel by viewModelProvider { kodein.instance<DetailViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel.getContactInfo(getIdIntent())
                .let {
                    manageState(it)
                }
    }

    fun feedLabels(label: Label) {
        label.apply {
            detailName.hint = labelName
            detailEmail.hint = labelEmail
            detailPhone.hint = labelTelephone
            detailFantasyName.hint = labelFantasyName
            detailCnpj.hint = labelCnpj
            detailTextMei.text = mei.labelMei
            detailPositiveOption.text = mei.labelPositiveOption
            detailNegativeOption.text = mei.labelNegativeOption
        }
    }

    fun feedFields(contact: DetailedContact) {
        contact.apply {
            detailName
            detailName.editText?.setText(name)
            detailEmail.editText?.setText(email)
            detailPhone.editText?.setText(phone)
            detailFantasyName.editText?.setText(companyName)
            detailCnpj.editText?.setText(cnpj)
            detailPositiveOption.isChecked = isMei
            detailNegativeOption.isChecked = !isMei
        }
    }

    fun setUpListener() {
        detailExcludeAction.setOnClickListener {
            viewModel.excludeContact(getIdIntent())
                    .let {
                        finish()
                    }
        }
    }

    fun manageState(state: State) {
        when (state) {
            State.Error -> toast(getString(R.string.generic_error_msg))
            is State.Success -> {
                feedLabels(state.label)
                feedFields(state.detailedContact)
                setUpListener()
            }
        }
    }

    private fun getIdIntent(): Int {
        return intent.extras.getInt(ID_CONTACT, 0)
    }

    companion object {
        val ID_CONTACT = "ID"

        fun intentToDetail(id: Int): Intent {
            return Intent().apply {
                putExtra(ID_CONTACT, id)
                data = Uri.parse("app://open.detail")
            }
        }
    }
}
