package sample.kanda.mvvm.register.validators

import sample.kanda.mvvm.register.*
import sample.kanda.mvvm.register.FieldType.*

/**
 * Created by caique on 2/19/18.
 */
class FieldsValidator {

    private val userNameValidator by lazy { UserNameValidator() }
    private val phoneValidator by lazy { PhoneValidator() }
    private val emailValidator by lazy { EmailValidator() }
    private val cnpjValidator by lazy { CnpjValidator() }
    private val simpleValidator by lazy { SimpleValidator() }

    fun checkFields(contact: UserContactInput): List<FieldType> {
        val listFields = mutableListOf<FieldType>()
        when {
            !userNameValidator.isValid(contact.name) -> listFields.add(NAME)

            !phoneValidator.isValid(contact.telephone) -> listFields.add(PHONE)

            !emailValidator.isValid(contact.email) -> listFields.add(EMAIL)

            !cnpjValidator.isValid(contact.cnpj) -> listFields.add(CNPJ)

            !simpleValidator.isValid(contact.fantasyName) -> listFields.add(COMPANY)

            contact.isMei == null -> listFields.add(MEI)

        }
        return listFields
    }
}

