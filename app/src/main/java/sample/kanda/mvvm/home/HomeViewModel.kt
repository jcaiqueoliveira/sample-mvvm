package sample.kanda.mvvm.home

import android.arch.lifecycle.ViewModel

import sample.kanda.domain.RetrieveContacts

/**
 * Created by jcosilva on 2/6/2018.
 */
class HomeViewModel(private val contacts: RetrieveContacts) : ViewModel() {

    fun loadContacts(): State {
        return contacts
                .getAll()
                .map { ContactToRowMapper(it) }
                .let {
                    if (it.isEmpty()) State.EmptyState else State.ListContacts(it)
                }
    }

}

sealed class State {
    data class ListContacts(val listContacts: List<ContactRow>) : State()
    object EmptyState : State()
}