package sample.kanda.mvvm.home

import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/7/2018.
 */
class ModelKtTest {

    lateinit var contact: Contact

    @Before
    fun setUp() {
        contact = Contact(
                name = anyString(),
                email = anyString(),
                telephone = anyString(),
                fantasyName = anyString(),
                cnpj = anyString(),
                isMei = true)

    }

    @Test
    fun `should return correctly the initials of propertyName`() {
        val contactMapped = RobotHome(contact).mapper()

        Assert.assertTrue(contact.name == contactMapped.propertyName)
        Assert.assertTrue(contact.fantasyName == contactMapped.companyName)
    }

    @Test
    fun `should return correctly initial of name given that is a not empty name`() {
        val contact1 = Contact(
                name = "A B C",
                email = anyString(),
                telephone = anyString(),
                fantasyName = anyString(),
                cnpj = anyString(),
                isMei = true)

        val initials = RobotHome(contact1).initials()

        assertTrue(initials.length <= 3)
        assertTrue(initials.isNotEmpty())
        assertTrue(initials == "ABC")
    }


}