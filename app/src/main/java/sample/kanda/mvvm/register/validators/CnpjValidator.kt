package sample.kanda.mvvm.register.validators

import sample.kanda.mvvm.register.Validator
import java.util.regex.Pattern

/**
 * Created by caique on 2/19/18.
 */
class CnpjValidator : Validator {

    private val REGEX = "(^[0-9]{2,3}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}-[0-9]{2}\$)"
    private val cnpjPattern = Pattern.compile(REGEX)

    override fun isValid(field: String): Boolean {
        return field.isNotEmpty() && cnpjPattern.matcher(field).matches()
    }
}