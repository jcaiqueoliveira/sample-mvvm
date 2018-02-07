package sample.kanda.mvvm.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import sample.kanda.domain.ContactManagerUseCase
import sample.kanda.domain.Label

/**
 * Created by jcosilva on 2/6/2018.
 */
class HomeViewModel(private val contactManagerUseCase: ContactManagerUseCase) : ViewModel() {

    val liveData = MutableLiveData<State>()

    fun init() {
        liveData.value = State.EmptyState
    }

}

sealed class Event {
    object AddContact : Event()
}

sealed class State {
    data class InitFields(val label: Label) : State()
    object EmptyState : State()
}