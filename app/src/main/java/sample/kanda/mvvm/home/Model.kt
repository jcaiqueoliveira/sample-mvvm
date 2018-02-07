package sample.kanda.mvvm.home

import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/7/2018.
 */

data class ContactPresentation(val companyName: String, val propertyName: String)

fun ContactPresentation.getInitials(): String {
    return propertyName
            .split(" ")
            .take(3)
            .map { it.first() }
            .joinToString("", limit = 3)
}

object MapperContactToPresentation {
    operator fun invoke(contact: Contact): ContactPresentation {
        return ContactPresentation(
                companyName = contact.fantasyName,
                propertyName = contact.name)
    }
}