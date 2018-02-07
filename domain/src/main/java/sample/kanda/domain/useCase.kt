package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */
class ContactManagerUseCase(val dataSource: LocalRepository) {

    fun saveContact(person: Contact) = dataSource.addContact(person)

    fun retrieveContacts() = dataSource.getContacts()

}