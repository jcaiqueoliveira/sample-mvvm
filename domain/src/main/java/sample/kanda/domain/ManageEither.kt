package sample.kanda.domain

/**
 * Created by jcosilva on 2/21/2018.
 */

inline fun <T> tryOrError(func: () -> T): Either<T> {
    return try {
        Either.Success(func())
    } catch (t: Throwable) {
        Either.Error(t)
    }
}

inline fun <T, R> Either<T>.map(crossinline func: (T) -> R): Either<R> {
    return when (this) {
        is Either.Success -> tryOrError { func.invoke(this.value) }
        is Either.Error -> this
    }
}

inline fun <T, R> Either<T>.flatMap(crossinline func: (T) -> Either<R>): Either<R> {
    return when (this) {
        is Either.Success -> func(this.value)
        is Either.Error -> this
    }
}
