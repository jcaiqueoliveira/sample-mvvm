package sample.kanda.mvvm.detail

import android.content.Intent
import android.support.test.espresso.Espresso
import android.support.test.runner.AndroidJUnit4
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.data.InMemory
import sample.kanda.data.InMemoryLabels
import sample.kanda.domain.RemoveContact
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.RetrieveLabels
import sample.util.ActivityRule

/**
 * Created by caique on 2/20/18.
 */
@RunWith(AndroidJUnit4::class)
class DetailActivityTest : ActivityRule<DetailActivity>(DetailActivity::class.java) {

    lateinit var retrieveContacts: RetrieveContacts
    lateinit var retrieveLabels: RetrieveLabels
    lateinit var mockRemoveContact: RemoveContact
    val robot: DetailRobot = DetailRobot()

    @Before
    fun beforeEachTest() {
        super.beforeTests()

        addModule(Kodein.Module(allowSilentOverride = true) {
            bind<RetrieveContacts>() with singleton { InMemory() }
            bind<RetrieveLabels>() with singleton { InMemoryLabels() }
            bind<RemoveContact>() with singleton { mock<RemoveContact>() }
        })

        retrieveContacts = injector.instance()
        retrieveLabels = injector.instance()
        mockRemoveContact = injector.instance()
    }

    @Test
    fun shouldShowLabelsAndContactInfoCorrectly() {
        val pair = retrieveContacts
                .getContact(0)
                .map { ContactToDetailedMapper(it) }
                .zip(retrieveLabels.getScreenLabels())
                .first()

        val intent = Intent()
                .putExtra(DetailActivity.ID_CONTACT, 0)

        startActivity(intent)

        Espresso.closeSoftKeyboard()

        robot
                .withPair(pair)
                .checkIfContactIsShownCorrectly()
                .checkIfLabelsAreShownCorrectly()
                .excludeButton()

        verify(mockRemoveContact, times(1)).excludeContact(0)


    }
}