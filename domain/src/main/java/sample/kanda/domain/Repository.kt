package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

interface LocalRepository {
    fun create(company: Company)

    fun getCompanies(): List<Company>
}

interface FieldsRepository {
    fun create(label: Label)

    fun getLabelsScreen(): Label
}