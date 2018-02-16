package sample.kanda.data.local.contact

import sample.kanda.domain.Contact
import sample.kanda.domain.RetrieveContacts

/**
 * Created by caique on 2/16/18.
 */
class ContactDataSource(val contactDao: ContactDao) : RetrieveContacts {
    override fun getAll(): List<Contact> {
        return contactDao.getAllContacts()
                .map { ContactEntityToDomain(it) }
    }

    override fun getContact(id: Int): List<Contact> {
        return arrayListOf(contactDao.findContactById(id))
                .map { ContactEntityToDomain(it) }
    }
}

