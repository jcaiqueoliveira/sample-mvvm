package sample.kanda.mvvm.home

import android.arch.lifecycle.ViewModel

import sample.kanda.domain.Label

import sample.kanda.domain.RetrieveContacts

/**
 * Created by jcosilva on 2/6/2018.
 */
class HomeViewModel(private val contacts: RetrieveContacts) : ViewModel() {

    fun execute(): State {
        return contacts
                .getAll()
                .map { MapperContactToPresentation(it) }
                .let {
                    if (it.isEmpty()) State.EmptyState else State.ListContacts(it)
                }
    }
}

sealed class Event {
    object AddContact : Event()
}

sealed class State {
    data class ListContacts(val listContacts: List<ContactPresentation>) : State()
    data class InitFields(val label: Label) : State()
    object EmptyState : State()
}