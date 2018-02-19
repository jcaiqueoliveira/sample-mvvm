package sample.kanda.mvvm.register

import android.arch.lifecycle.ViewModel
import sample.kanda.domain.Label
import sample.kanda.domain.RetrieveLabels
import sample.kanda.domain.SaveContacts
import sample.kanda.mvvm.register.validators.FieldsValidator

/**
 * Created by jcosilva on 2/15/2018.
 */
class RegisterViewModel(
        private val contactDataSource: SaveContacts,
        private val fieldDataSource: RetrieveLabels,
        private val fieldsValidator: FieldsValidator) : ViewModel() {

    var contact = UserContactInput()

    fun getLabels(): Label {
        return fieldDataSource
                .getScreenLabels()
                .first()
    }

    fun save(userContactInput: UserContactInput): State {
        this.contact = userContactInput
        val checkFields = fieldsValidator.checkFields(contact)
        return when (checkFields.isEmpty()) {
            true -> {
                contactDataSource
                        .save(ContactInputToDomainMapper(contact))
                State.Success
            }
            false -> {
                State.InvalidField(checkFields)
            }
        }
    }

}
