package sample.kanda.data


import sample.kanda.data.InMemory.State.EMPTY_STATE
import sample.kanda.domain.Contact
import sample.kanda.domain.RetrieveContacts

/**
 * Created by jcosilva on 2/5/2018.
 */

class InMemory : RetrieveContacts {

    private var nextState: State = EMPTY_STATE
    private val contact = Contact(
            id = 0,
            name = "Kanda Sup Sa",
            email = "Kanda@Kanda.Kanda",
            telephone = 12_34567_8900.toString(),
            fantasyName = "Kendo Kappa Keppo",
            cnpj = 27_825_363_0001_12.toString(),
            isMei = true)

    override fun getContact(id: Int): List<Contact> {
        return listOf(contact)
    }

    override fun getAll(): List<Contact> {
        val list: MutableList<Contact> = mutableListOf()

        if (nextState == EMPTY_STATE) {
            return list
        }
        return list.apply {
            add(contact)
            add(contact)
            add(contact)
            add(contact)
        }
    }

    fun nextState(state: State) {
        nextState = state
    }

    sealed class State {
        object EMPTY_STATE : State()
        object LIST_WITH_ITEMS : State()
    }
}

