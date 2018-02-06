package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */
class ContacManagerUseCase(val dataSource: LocalRepository) {

    fun saveContact(person: Contact) {
        dataSource.addContact(person)
    }

}