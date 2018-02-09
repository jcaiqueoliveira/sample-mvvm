package sample.kanda.mvvm.home

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import sample.kanda.domain.Contact

/**
 * Created by caique on 2/9/18.
 */
class ContactToRowMapperTest {

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

        val contactMapped = ContactToRowMapper(contact)

        Assertions.assertThat(contact.name)
                .isEqualTo(contactMapped.propertyName)

        Assertions.assertThat(contact.fantasyName)
                .isEqualTo(contactMapped.companyName)
    }


    @Test
    fun `should return correctly initial of name given that is a not empty name`() {
        val contact1 = Contact(
                name = "A B C D",
                email = anyString(),
                telephone = anyString(),
                fantasyName = anyString(),
                cnpj = anyString(),
                isMei = true)

        assertThat(ContactToRowMapper(contact1).initials)
                .startsWith("A")
                .endsWith("C")
                .isEqualToIgnoringCase("ABC")
    }


    @Test
    fun `should return initials of name given that is a empty name`() {
        val contact1 = Contact(
                name = "  ",
                email = anyString(),
                telephone = anyString(),
                fantasyName = anyString(),
                cnpj = anyString(),
                isMei = true)

        assertThat(ContactToRowMapper(contact1).initials)
                .isEqualToIgnoringCase("?")
    }
}