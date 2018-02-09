package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

interface FieldsRepository {
    fun create(label: Label)

    fun getLabelsByScreen(): Label
}