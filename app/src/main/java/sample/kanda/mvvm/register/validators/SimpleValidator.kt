package sample.kanda.mvvm.register.validators

import sample.kanda.mvvm.register.Validator

/**
 * Created by caique on 2/19/18.
 */
class SimpleValidator : Validator {
    override fun isValid(field: String): Boolean {
        return field.isNotEmpty() && field.trim().length >= 2
    }
}