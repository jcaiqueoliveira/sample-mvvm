package sample.kanda.mvvm.register

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sample.kanda.mvvm.register.validators.CnpjValidator


/**
 * Created by caique on 2/19/18.
 */
class CnpjValidatorTest {
    @Test
    fun `check if is valid cnpj`() {

        val validator = CnpjValidator()

        assertThat(validator.isValid("01.004.717/0001-74"))
                .isTrue()

        assertThat(validator.isValid("01.004.7170001-74"))
                .isFalse()
    }

}