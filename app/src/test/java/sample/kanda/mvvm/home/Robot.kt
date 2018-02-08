package sample.kanda.mvvm.home

import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/7/2018.
 */

class RobotHome(private val contact: Contact) {
    private val contactMapped: ContactPresentation = MapperContactToPresentation(contact)

    fun mapper() = contactMapped

    fun initials(): String = contactMapped.getInitials()

}