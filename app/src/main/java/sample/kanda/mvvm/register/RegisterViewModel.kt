package sample.kanda.mvvm.register

import android.arch.lifecycle.ViewModel
import sample.kanda.domain.*
import sample.kanda.mvvm.register.validators.FieldsValidator

/**
 * Created by jcosilva on 2/15/2018.
 */
class RegisterViewModel(
        private val contactDataSource: SaveContacts,
        private val fieldDataSource: RetrieveLabels,
        private val fieldsValidator: FieldsValidator) : ViewModel() {

    var contact = UserContactInput()

    fun getLabels(): State {
        return fieldDataSource
                .getScreenLabels()
                .map { it.first() }
                .let {
                    when (it) {
                        is Either.Error -> State.Error
                        is Either.Success -> State.ShowLabels(it.value)
                    }
                }
    }

    fun save(userContactInput: UserContactInput): State {
        this.contact = userContactInput
        val checkFields = fieldsValidator.checkFields(contact)
        return when (checkFields.isEmpty()) {
            true -> {
                contactDataSource
                        .save(ContactInputToDomainMapper(contact))
                State.Success_Register
            }
            false -> {
                State.InvalidField(checkFields)
            }
        }
    }
}

sealed class State {
    object Success_Register : State()
    object Error : State()
    data class InvalidField(var fields: List<FieldType>) : State()
    data class ShowLabels(val label: Label) : State()
}
