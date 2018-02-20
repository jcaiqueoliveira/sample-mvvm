package sample.kanda.mvvm.home

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.android.synthetic.main.activity_main.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowActivity
import org.robolectric.shadows.ShadowApplication
import sample.kanda.mvvm.detail.DetailActivity


/**
 * Created by caique on 2/16/18.
 */
@RunWith(RobolectricTestRunner::class)
class IntentHomeActivityTest {

    val contactRow = mock<ContactRow>()
    lateinit var shadowActivity: ShadowActivity
    lateinit var application: ShadowApplication
    lateinit var homeActivity: HomeActivity
    @Before()
    fun before() {
        homeActivity = Robolectric.setupActivity(HomeActivity::class.java)

        shadowActivity = shadowOf(homeActivity)

        application = shadowOf(RuntimeEnvironment.application)


    }

    @Test
    fun `check if intent to next activity is correctly`() {

        whenever(contactRow.id).thenReturn(0)

        homeActivity.onClick(contactRow)
        val id = shadowActivity
                .peekNextStartedActivity()
                .extras
                .get(DetailActivity.ID_CONTACT) as Int

        assertThat(id).isEqualTo(0)

        assertThat(application.nextStartedActivity)
                .isNotNull()

    }

    @Test
    fun `check if intent to registerActivity after click in fab button`() {

        val activity = Robolectric.setupActivity(HomeActivity::class.java)

        shadowActivity = Shadows.shadowOf(activity)

        activity.addContact.performClick()

        val startedIntent = shadowActivity.nextStartedActivity
        val shadowIntent = Shadows.shadowOf(startedIntent)

        assertThat(shadowIntent)
                .isNotNull()
    }

}