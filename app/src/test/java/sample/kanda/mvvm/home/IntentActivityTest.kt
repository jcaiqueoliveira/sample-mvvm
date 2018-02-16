package sample.kanda.mvvm.home

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowActivity
import sample.kanda.mvvm.BuildConfig
import sample.kanda.mvvm.detail.DetailActivity


/**
 * Created by caique on 2/16/18.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class IntentActivityTest {

    val contactRow = mock<ContactRow>()
    lateinit var shadowActivity: ShadowActivity

    @Before()
    fun before() {
        val homeActivity = Robolectric.setupActivity(HomeActivity::class.java)
        shadowActivity = shadowOf(homeActivity)

        whenever(contactRow.id).thenReturn(0)
        homeActivity.onClick(contactRow)
    }

    @Test
    fun check_if_intent_to_next_activity_is_correctly() {

        val application = shadowOf(RuntimeEnvironment.application)

        val id = shadowActivity
                .peekNextStartedActivity()
                .extras
                .get(DetailActivity.ID_CONTACT) as Int

        assertThat(id).isEqualTo(0)

        assertThat(application.nextStartedActivity)
                .isNotNull()


    }
}