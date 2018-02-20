package sample.kanda.mvvm.register

import android.support.test.espresso.Espresso
import android.support.test.runner.AndroidJUnit4
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.data.InMemoryLabels
import sample.kanda.domain.RetrieveLabels
import sample.util.ActivityRule

/**
 * Created by caique on 2/19/18.
 */

@RunWith(AndroidJUnit4::class)
class RegisterActivityTest : ActivityRule<RegisterActivity>(RegisterActivity::class.java) {

    lateinit var labelsDataSource: RetrieveLabels
    val robotRegister = RobotRegister()

    @Before
    fun beforeEachTest() {

        addModule(Kodein.Module(allowSilentOverride = true) {
            bind<RetrieveLabels>() with singleton { InMemoryLabels() }
        })

        labelsDataSource = injector.instance()

    }

    @Test
    fun should_show_the_labels_correctly_using_the_response_of_request() {

        val label = labelsDataSource.getScreenLabels().first()

        startActivity()

        Espresso.closeSoftKeyboard()

        robotRegister
                .withLabel(label)
                .checkIfViewsWithHintAreShownCorrectly()
                .checkViewsTextAreShownCorrectly()

    }
}