package sample.kanda.mvvm.home

import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/7/2018.
 */

data class ContactPresentation(val companyName: String, val propertyName: String)

object MapperContactToPresentation {
    operator fun invoke(contact: Contact): ContactPresentation {
        return ContactPresentation(
                companyName = contact.fantasyName,
                propertyName = contact.name)
    }
}