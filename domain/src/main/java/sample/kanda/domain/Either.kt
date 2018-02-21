package sample.kanda.domain

/**
 * Created by jcosilva on 2/21/2018.
 */
sealed class Either<out T> {
    data class Error(val t: Throwable) : Either<Nothing>()
    data class Success<T>(val value: T) : Either<T>()
}