package sample.kanda.mvvm.home

import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/7/2018.
 */
class ModelKtTest {

    @Test
    fun `should return correctly the initials of propertyName`() {
        val contact = Contact(anyString(), anyString(), anyString(), anyString(), anyString(), true)
        RobotHome(contact).mapper()
    }
}