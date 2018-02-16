package sample.kanda.mvvm

import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasData
import android.support.test.runner.AndroidJUnit4
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import sample.kanda.domain.Contact
import sample.kanda.domain.RetrieveContacts
import sample.kanda.mvvm.Injector.Companion.LOCAL
import sample.kanda.mvvm.home.HomeActivity
import sample.util.ActivityRule

/**
 * Created by jcosilva on 2/14/2018.
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest : ActivityRule<HomeActivity>(HomeActivity::class.java) {

    lateinit var mockDataSource: RetrieveContacts

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
        super.beforeTests()

        addModule(Kodein.Module(allowSilentOverride = true) {
            bind<RetrieveContacts>() with singleton { mock<RetrieveContacts>() }
        })

        mockDataSource = injector.instance()

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

        intended(hasData("app://open.detail"))

    }

    @Test
    fun checkEmptyState() {

        whenever(mockDataSource.getAll()).thenReturn(emptyList())

        startActivity()

        robotHome
                .checkEmptyState()

    }

    @After
    fun tearDown() {
        super.afterTests()
    }

}