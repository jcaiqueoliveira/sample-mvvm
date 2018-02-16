package sample.kanda.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import sample.kanda.data.local.contact.ContactEntity
import sample.kanda.data.local.contact.ContactEntityToDomain

/**
 * Created by caique on 2/9/18.
 */
class ContactEntityToDomainTest {

    lateinit var contact: ContactEntity

    @Before
    fun setUp() {
        contact = ContactEntity(
                name = "NOME",
                email = "abc@abc",
                phone = anyString(),
                fantasy_Name = anyString(),
                cnpj = anyString(),
                mei = true)
    }

    @Test
    fun `should map correctly`() {

        val mapped = ContactEntityToDomain(contact)

        assertThat(contact.name)
                .isEqualTo(mapped.name)

        assertThat(contact.email)
                .isEqualTo(mapped.email)
    }
}