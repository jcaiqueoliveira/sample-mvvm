package sample.kanda.data.local.contact

import sample.kanda.domain.Contact
import sample.kanda.domain.RemoveContact
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.SaveContacts
import sample.kanda.domain.*

/**
 * Created by caique on 2/16/18.
 */
class ContactDataSource(val contactDao: ContactDao) : RetrieveContacts, RemoveContact, SaveContacts {

    override fun save(contact: Contact) {
        contactDao
                .insertContact(ContactDomainToEntityMapper(contact))
    }

    override fun getAll(): List<Contact> {
        return contactDao.getAllContacts()
                .map { ContactEntityToDomain(it) }
    }

    override fun getContact(id: Int): Either<List<Contact>> {
        return tryOrError {
            listOf(contactDao.findContactById(id))
                    .map { ContactEntityToDomain(it) }
        }
    }

    override fun excludeContact(contactId: Int) {
        val contact = contactDao.findContactById(contactId)
        contactDao.deleteContact(contact)
    }

}

