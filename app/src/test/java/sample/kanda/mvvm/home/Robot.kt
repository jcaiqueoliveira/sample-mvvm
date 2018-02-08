package sample.kanda.mvvm.home

import org.junit.Assert.assertTrue
import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/7/2018.
 */

class RobotHome(private val contact: Contact) {
    private val contactMapped: ContactPresentation = MapperContactToPresentation(contact)

    fun mapper() {
        assertTrue(contact.name == contactMapped.propertyName)
    }

    fun initials() {
        assertTrue(contactMapped.getInitials().length <= 3)
        assertTrue(contactMapped.getInitials().isNotEmpty())
    }

}