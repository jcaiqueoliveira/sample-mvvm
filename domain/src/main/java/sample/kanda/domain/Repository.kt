package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

interface LocalRepository {
    fun save(any: Any)

    fun listCompanies(): List<*>
}

interface FieldsRepository {

}