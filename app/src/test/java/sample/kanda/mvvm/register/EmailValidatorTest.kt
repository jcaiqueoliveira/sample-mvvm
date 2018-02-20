package sample.kanda.mvvm.register

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sample.kanda.mvvm.register.validators.EmailValidator


/**
 * Created by caique on 2/19/18.
 */
class EmailValidatorTest {

    @Test
    fun `should validate a email correctly`() {

        assertThat(EmailValidator().isValid("abc@abc.com"))
                .isTrue()

    }

    @Test
    fun `should invalidate a not correctly email`() {

        assertThat(EmailValidator().isValid("x*@abc.com"))
                .isFalse()

        assertThat(assertThat(EmailValidator().isValid("x@@abc.com"))
                .isFalse())

        assertThat(EmailValidator().isValid("x@abc"))
                .isFalse()

        assertThat(EmailValidator().isValid("zignd.igor@gmail.com.br.br"))
                .isFalse()


    }

}