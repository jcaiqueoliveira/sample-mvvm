package sample.kanda.mvvm.register

/**
 * Created by caique on 2/19/18.
 */
sealed class State {
    object Success : State()
    data class InvalidField(var fields: List<FieldType>) : State()
}