package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

interface LocalRepository {
    fun save(company: Company)

    fun getCompanies(): List<Company>
}

interface FieldsRepository {
    fun save(label: Label)

    fun getLabelsScreen(): Label
}