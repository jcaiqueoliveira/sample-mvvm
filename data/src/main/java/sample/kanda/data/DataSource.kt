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


class InMemory : RetrieveContacts {
    override fun getAll(): List<Contact> {
        val list: MutableList<Contact> = mutableListOf()
        val contact = Contact(
                name = "Kanda Sup Sa",
                email = "Kanda@Kanda.Kanda",
                telephone = 12_34567_8900.toString(),
                fantasyName = "Kendo Kappa Keppo",
                cnpj = 27_825_363_0001_12.toString(),
                isMei = true)


        return list.apply {
            add(contact)
            add(contact)
            add(contact)
            add(contact)
        }
    }

}
