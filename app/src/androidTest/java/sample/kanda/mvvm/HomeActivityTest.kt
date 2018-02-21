package sample.kanda.mvvm

import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasData
import android.support.test.runner.AndroidJUnit4
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.data.InMemory
import sample.kanda.data.InMemory.State
import sample.kanda.data.InMemoryLabels
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.RetrieveLabels
import sample.kanda.mvvm.home.HomeActivity
import sample.util.ActivityRule

/**
 * Created by jcosilva on 2/14/2018.
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest : ActivityRule<HomeActivity>(HomeActivity::class.java) {

    lateinit var retriveContacts: RetrieveContacts

    val robotHome: RobotHome = RobotHome()

    @Before
    fun beforeEachTest() {
        super.beforeTests()

        addModule(Kodein.Module(allowSilentOverride = true) {
            bind<RetrieveContacts>() with singleton { InMemory() }
            bind<RetrieveLabels>() with singleton { InMemoryLabels() }
        })

        retriveContacts = injector.instance()

    }

    @Test
    fun should_click_in_some_item_and_navigate_to_next_screen() {

        (retriveContacts as InMemory).nextState(State.LIST_WITH_ITEMS)

        val listContact = retriveContacts.getAll()

        startActivity()

        robotHome
                .checkIfListIsVisible()
                .performClickItemList(0)

        assertThat(rule.activity.contactList.adapter.itemCount, equalTo(listContact.size))

        intended(hasData("app://open.detail"))

    }

    @Test
    fun checkEmptyState() {
        (retriveContacts as InMemory).nextState(State.EMPTY_STATE)

        startActivity()

        robotHome
                .checkEmptyState()

    }

    @After
    fun tearDown() {
        super.afterTests()
    }

}