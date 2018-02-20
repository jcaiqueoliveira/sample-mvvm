package sample.kanda.mvvm.register.validators

import sample.kanda.mvvm.register.Validator
import java.util.regex.Pattern

/**
 * Created by caique on 2/19/18.
 */
class PhoneValidator : Validator {
    private val REGEX = "^\\([1-9]{2}\\) [9]{0,1}[6-9]{1}[0-9]{3}\\-[0-9]{4}\$"
    private val phonePattern = Pattern.compile(REGEX)

    override fun isValid(field: String): Boolean {
        return field.isNotEmpty() && phonePattern.matcher(field).matches()
    }
}