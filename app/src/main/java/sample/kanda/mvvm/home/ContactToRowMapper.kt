package sample.kanda.mvvm.home

import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/7/2018.
 */


object ContactToRowMapper {
    operator fun invoke(contact: Contact): ContactRow {
        return ContactRow(
                companyName = contact.fantasyName,
                propertyName = contact.name,
                initials = getInitialsName(contact.name))
    }

    private fun getInitialsName(name: String): String {
        return name
                .split(" ")
                .filter { it.isNotEmpty() }
                .take(3)
                .map { it.first() }
                .joinToString("", limit = 3)
                .let { if (it.isEmpty()) "?" else it }
                .capitalize()
    }
}