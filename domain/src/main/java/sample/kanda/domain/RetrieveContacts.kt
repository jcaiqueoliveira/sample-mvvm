package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */
interface RetrieveContacts {

    fun getAll(): List<Contact>

    fun getContact(id: Int): List<Contact>

}
