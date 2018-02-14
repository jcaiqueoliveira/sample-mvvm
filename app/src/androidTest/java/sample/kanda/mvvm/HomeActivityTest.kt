package sample.kanda.mvvm

import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras
import android.support.test.runner.AndroidJUnit4
import com.github.salomonbrys.kodein.instance
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.domain.Contact
import sample.kanda.domain.RetrieveContacts
import sample.kanda.mvvm.detail.DetailActivity
import sample.kanda.mvvm.home.HomeActivity
import sample.util.ActivityRule

/**
 * Created by jcosilva on 2/14/2018.
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest : ActivityRule<HomeActivity>(HomeActivity::class.java) {

    var mockDataSource: RetrieveContacts = injector.instance()

    val robotHome: RobotHome = RobotHome()

    val list: MutableList<Contact> = mutableListOf()

    val contact = Contact(
            name = "Kanda Sup Sa",
            email = "Kanda@Kanda.Kanda",
            telephone = 12_34567_8900.toString(),
            fantasyName = "Kendo Kappa Keppo",
            cnpj = 27_825_363_0001_12.toString(),
            isMei = true)

    @Before
    fun beforeEachTest() {
        Intents.init()

        list.apply {
            add(contact)
            add(contact)
        }
    }

    @Test
    fun should_click_in_some_item_and_navigate_to_next_screen() {

        whenever(mockDataSource.getAll()).thenReturn(list)

        startActivity()

        robotHome
                .checkIfListIsVisible()
                .performClickItemList(0)

        assertThat(rule.activity.contactList.adapter.itemCount, equalTo(list.size))

        intended(allOf(
                hasComponent(DetailActivity::class.java.name),
                hasExtras(hasEntry(equalTo(DetailActivity.ID_CONTACT), equalTo(0)))
        ))

    }

    @Test
    fun checkEmptyState() {
        whenever(mockDataSource.getAll()).thenReturn(emptyList())

        startActivity()

        robotHome.checkEmptyState()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

}