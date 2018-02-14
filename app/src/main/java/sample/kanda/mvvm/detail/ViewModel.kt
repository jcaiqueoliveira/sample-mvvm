package sample.kanda.mvvm.detail

import android.arch.lifecycle.ViewModel
import sample.kanda.domain.Label
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.RetrieveLabels

/**
 * Created by jcosilva on 2/15/2018.
 */
class DetailViewModel(
        private val contactDataSource: RetrieveContacts,
        private val fieldDataSource: RetrieveLabels) : ViewModel() {

    fun getContactInfo(id: Int): Pair<DetailedContact, Label> {
        return contactDataSource
                .getContact(id)
                .map { ContactToDetailedMapper(it) }
                .zip(fieldDataSource.getScreenLabels())
                .first()
    }

}