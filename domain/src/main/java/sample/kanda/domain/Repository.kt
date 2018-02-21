package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

interface RetrieveLabels {

    fun getScreenLabels(): Either<List<Label>>
}