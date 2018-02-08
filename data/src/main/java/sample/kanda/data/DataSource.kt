package sample.kanda.data

import sample.kanda.domain.*

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

class RetrieveContactsDataSource : RetrieveContacts {
    override fun getAll(): List<Contact> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
