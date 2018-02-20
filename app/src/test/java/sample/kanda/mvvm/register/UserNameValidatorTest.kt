package sample.kanda.mvvm.register

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sample.kanda.mvvm.register.validators.UserNameValidator


/**
 * Created by caique on 2/19/18.
 */
class UserNameValidatorTest {
    @Test
    fun `check if is a valid name`() {
        val validator = UserNameValidator()

        assertThat(validator.isValid("Lylie Maka"))
                .isTrue()

        assertThat(validator.isValid("José Pedro"))
                .isTrue()

        assertThat(validator.isValid("Uncle Bob"))
                .isTrue()
    }

    @Test
    fun `should invalidate a wrong name`() {
        val validator = UserNameValidator()
        assertThat(validator.isValid("1Nome Com Numero"))
                .isFalse()

        assertThat(validator.isValid("...Caio Pedro"))
                .isFalse()

    }
}