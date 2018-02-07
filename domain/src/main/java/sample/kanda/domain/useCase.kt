package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */
class ContactManagerUseCase(private val dataSource: LocalRepository) {

    fun saveContact(person: Contact) {
        dataSource.addContact(person)
    }

}


class HomeUseCase(private val datasource: FieldsRepository) {


}