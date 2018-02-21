package sample.kanda.mvvm.detail

import android.arch.lifecycle.ViewModel
import sample.kanda.domain.*


/**
 * Created by jcosilva on 2/15/2018.
 */
class DetailViewModel(
        private val retriveContact: RetrieveContacts,
        private val removeContact: RemoveContact,
        private val fieldDataSource: RetrieveLabels) : ViewModel() {

    fun getContactInfo(id: Int): State {
        return retriveContact
                .getContact(id)
                .map { it.first() }
                .map { ContactToDetailedMapper(it) }
                .flatMap { detailContact ->
                    fieldDataSource.getScreenLabels()
                            .map { it.first() to detailContact }
                }
                .let {
                    when (it) {
                        is Either.Success -> State.Success(it.value.first, it.value.second)
                        is Either.Error -> State.Error
                    }
                }
    }

    fun excludeContact(id: Int) {
        removeContact.excludeContact(id)
    }

}

sealed class State {
    object Error : State()
    data class Success(val label: Label, val detailedContact: DetailedContact) : State()
}