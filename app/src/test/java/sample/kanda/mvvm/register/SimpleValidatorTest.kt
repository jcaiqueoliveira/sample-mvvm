package sample.kanda.mvvm.register

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sample.kanda.mvvm.register.validators.SimpleValidator


/**
 * Created by caique on 2/19/18.
 */
class SimpleValidatorTest {
    @Test
    fun `should validate correctly a random name`() {
        val validator = SimpleValidator()

        assertThat(validator.isValid("aaa111"))
                .isTrue()

        assertThat(validator.isValid("1a"))
                .isTrue()

        assertThat(validator.isValid("a"))
                .isFalse()
    }

}