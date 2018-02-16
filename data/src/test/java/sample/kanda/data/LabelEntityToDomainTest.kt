package sample.kanda.data

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import sample.kanda.data.local.contact.LabelEntity
import sample.kanda.data.local.contact.LabelEntityToDomain

/**
 * Created by caique on 2/16/18.
 */
class LabelEntityToDomainTest {

    lateinit var label: LabelEntity

    @Before
    fun setUp() {
        label = LabelEntity(
                name = "NOME",
                email = "abc@abc",
                phone = ArgumentMatchers.anyString(),
                fantasy_Name = ArgumentMatchers.anyString(),
                cnpj = ArgumentMatchers.anyString(),
                negative_option_mei = "nao",
                positive_option_mei = "sim",
                title_mei = "titulo")
    }

    @Test
    fun `should map correctly`() {

        val mapped = LabelEntityToDomain(label)

        assertThat(label.name)
                .isEqualTo(mapped.labelName)

        assertThat(label.email)
                .isEqualTo(mapped.labelEmail)
    }
}