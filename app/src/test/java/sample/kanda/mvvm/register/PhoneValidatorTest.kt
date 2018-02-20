package sample.kanda.mvvm.register

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sample.kanda.mvvm.register.validators.PhoneValidator

/**
 * Created by caique on 2/19/18.
 */
class PhoneValidatorTest {
    @Test
    fun `should validate a phone number correctly`() {
        val validator = PhoneValidator()

        assertThat(validator.isValid("(99) 99999-9999"))
                .isTrue()

        assertThat(validator.isValid("(99) 9999-9999"))
                .isTrue()
    }

    @Test
    fun `should invalidate a wrong phone number`() {
        val validator = PhoneValidator()

        assertThat(validator.isValid("(0) 99999-9999"))
                .isFalse()

        assertThat(validator.isValid("99999-9999"))
                .isFalse()

        assertThat(validator.isValid("(99) 99999-999"))
                .isFalse()
    }

}