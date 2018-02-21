package sample.kanda.mvvm.detail

import android.arch.lifecycle.ViewModel
import sample.kanda.domain.Label
import sample.kanda.domain.RemoveContact
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.RetrieveLabels

/**
 * Created by jcosilva on 2/15/2018.
 */
class DetailViewModel(
        private val retriveContact: RetrieveContacts,
        private val removeContact: RemoveContact,
        private val fieldDataSource: RetrieveLabels) : ViewModel() {

    fun getContactInfo(id: Int): Pair<DetailedContact, Label> {
        return retriveContact
                .getContact(id)
                .map { ContactToDetailedMapper(it) }
                .zip(fieldDataSource.getScreenLabels())
                .first()
    }


    fun excludeContact(id: Int) {
        removeContact.excludeContact(id)
    }

}