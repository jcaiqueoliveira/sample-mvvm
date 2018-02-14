package sample.kanda.mvvm

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import sample.kanda.mvvm.home.ViewHolder

/**
 * Created by jcosilva on 2/15/2018.
 */
class RobotHome {

    fun performClickItemList(position: Int): RobotHome {

        onView(ViewMatchers.withId(R.id.contactList))
                .perform(actionOnItemAtPosition<ViewHolder>(position, click()))

        return this
    }

    fun checkIfListIsVisible(): RobotHome {

        onView(withId(R.id.contactList)).check(matches(isDisplayed()))
        return this
    }

    fun checkEmptyState(): RobotHome {
        onView(withId(R.id.emptyState)).check(matches(isDisplayed()))
        return this
    }

}