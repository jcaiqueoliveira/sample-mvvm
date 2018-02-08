package sample.kanda.data

import sample.kanda.domain.Contact
import sample.kanda.domain.RetrieveContacts

/**
 * Created by jcosilva on 2/5/2018.
 */

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
