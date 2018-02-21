package sample.kanda.mvvm.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_register.*
import sample.kanda.domain.Label
import sample.kanda.mvvm.R
import sample.kanda.mvvm.clearErrorMsg
import sample.kanda.mvvm.register.FieldType.*
import sample.kanda.mvvm.toast
import sample.kanda.mvvm.viewModelProvider

class RegisterActivity : AppCompatActivity() {
    private val kodein by LazyKodein(appKodein)
    private val viewModel by viewModelProvider { kodein.instance<RegisterViewModel>() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        viewModel
                .getLabels()
                .let {
                    manageState(it)
                }

        setUpListeners()
    }

    fun setUpLabels(label: Label) {
        label.apply {
            registerName.hint = labelName
            registerEmail.hint = labelEmail
            registerCnpj.hint = labelCnpj
            registerCompany.hint = labelFantasyName
            registerTextMei.text = mei.labelMei
            registerPhone.hint = labelTelephone
            registerPositiveOption.text = mei.labelPositiveOption
            registerNegativeOption.text = mei.labelNegativeOption
        }
    }

    fun setUpListeners() {

        registerAction.setOnClickListener {
            viewModel.save(getUserContactInput())
                    .let { manageState(it) }
        }
    }

    private fun getUserContactInput(): UserContactInput {
        return UserContactInput(
                name = registerName.editText?.text.toString(),
                email = registerEmail.editText?.text.toString(),
                cnpj = registerCnpj.editText?.text.toString(),
                fantasyName = registerCompany.editText?.text.toString(),
                telephone = registerPhone.editText?.text.toString(),
                isMei = registerPositiveOption.isChecked
        )
    }

    private fun manageState(state: State) {
        when (state) {
            State.Success_Register -> success()
            is State.InvalidField -> showMessageToInvalidFields(state.fields)
            is State.ShowLabels -> setUpLabels(state.label)
            State.Error -> toast(getString(R.string.generic_error_msg))
        }
    }

    private fun success() {
        toast(getString(R.string.success_save_contact))

        finish()
    }

    private fun showMessageToInvalidFields(list: List<FieldType>) {
        removeErrorLabels()
        for (field in list) {
            when (field) {
                NAME -> registerName.error = getString(R.string.msg_error_invalid_field)
                EMAIL -> registerEmail.error = getString(R.string.msg_error_invalid_field)
                PHONE -> registerPhone.error = getString(R.string.msg_error_invalid_field)
                CNPJ -> registerCnpj.error = getString(R.string.msg_error_invalid_field)
                COMPANY -> registerCompany.error = getString(R.string.msg_error_invalid_field)
                MEI -> toast(getString(R.string.error_msg_mei))
            }
        }
    }

    private fun removeErrorLabels() {
        registerName.clearErrorMsg()
        registerName.clearErrorMsg()
        registerEmail.clearErrorMsg()
        registerPhone.clearErrorMsg()
        registerCnpj.clearErrorMsg()
        registerCompany.clearErrorMsg()
    }

}
