package sample.kanda.mvvm.register.validators

import sample.kanda.mvvm.register.Validator
import java.util.regex.Pattern

/**
 * Created by caique on 2/19/18.
 */
class UserNameValidator : Validator {
    val REGEX = "^([ \\u00c0-\\u01ffa-zA-Z'\\-])+\$"
    val namePattern = Pattern.compile(REGEX)

    override fun isValid(field: String): Boolean {
        return field.isNotEmpty() && namePattern.matcher(field).matches()
    }
}