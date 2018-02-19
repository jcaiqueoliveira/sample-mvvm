package sample.kanda.data.local.contact

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sample.kanda.domain.Contact

/**
 * Created by caique on 2/19/18.
 */
class ContactDomainToEntityMapperTest {


    @Test
    fun `should map correctly a contact domain to contact entity`() {
        val contact = Contact(
                name = "Kanda Sup Sa",
                email = "Kanda@Kanda.Kanda",
                telephone = 12_34567_8900.toString(),
                fantasyName = "Kendo Kappa Keppo",
                cnpj = 27_825_363_0001_12.toString(),
                isMei = true)

        val mapped = ContactDomainToEntityMapper(contact)
        assertThat(mapped.email)
                .isEqualTo(contact.email)

        assertThat(mapped.name)
                .isEqualTo(contact.name)

    }

}