package sample.kanda.mvvm.home

import android.arch.lifecycle.ViewModel
import sample.kanda.domain.Label
import sample.kanda.domain.RetrieveContacts

/**
 * Created by jcosilva on 2/6/2018.
 */
class HomeViewModel(private val contactManagerUseCase: RetrieveContacts) : ViewModel() {

    fun execute(): State {
        return State.EmptyState
    }

}

sealed class Event {
    object AddContact : Event()
}

sealed class State {
    data class InitFields(val label: Label) : State()
    object EmptyState : State()
}