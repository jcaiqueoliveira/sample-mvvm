package sample.kanda.data

import sample.kanda.domain.Contact
import sample.kanda.domain.FieldsRepository
import sample.kanda.domain.Label
import sample.kanda.domain.LocalRepository

/**
 * Created by jcosilva on 2/5/2018.
 */

class LocalDataSource : LocalRepository, FieldsRepository {
    override fun create(label: Label) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLabelsByScreen(): Label {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addContact(contact: Contact) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContacts(): List<Contact> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}