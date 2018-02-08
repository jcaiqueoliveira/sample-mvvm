package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */
<<<<<<< HEAD
class ContactManagerUseCase(val dataSource: LocalRepository) {

    fun saveContact(person: Contact) = dataSource.addContact(person)

    fun retrieveContacts() = dataSource.getContacts()

}
=======
interface RetrieveContacts {

    fun getAll(): List<Contact>

}
>>>>>>> step2
