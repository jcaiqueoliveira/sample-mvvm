package sample.kanda.mvvm.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import sample.kanda.domain.ContactManagerUseCase

/**
 * Created by jcosilva on 2/6/2018.
 */
class HomeViewModel(private val contactManagerUseCase: ContactManagerUseCase) : ViewModel() {

    val liveData = MutableLiveData<State>()

    fun init() {
        contactManagerUseCase
                .retrieveContacts()
                .map { MapperContactToPresentation(it) }
                .let {
                    if (it.isEmpty()) State.EmptyState else State.ListContacts(it)
                }
                .let { liveData.value = it }
    }

}

sealed class Event {
    object AddContact : Event()
}

sealed class State {
    data class ListContacts(val listContacts: List<ContactPresentation>) : State()
    object EmptyState : State()
}