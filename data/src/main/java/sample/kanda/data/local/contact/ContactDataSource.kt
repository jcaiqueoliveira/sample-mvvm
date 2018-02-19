package sample.kanda.data.local.contact

import sample.kanda.domain.Contact
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.SaveContacts

/**
 * Created by caique on 2/16/18.
 */
class ContactDataSource(val contactDao: ContactDao) : RetrieveContacts, SaveContacts {

    override fun save(contact: Contact) {
        contactDao
                .insertContact(ContactDomainToEntityMapper(contact))
    }

    override fun getAll(): List<Contact> {
        return contactDao.getAllContacts()
                .map { ContactEntityToDomain(it) }
    }

    override fun getContact(id: Int): List<Contact> {
        return arrayListOf(contactDao.findContactById(id))
                .map { ContactEntityToDomain(it) }
    }
}

