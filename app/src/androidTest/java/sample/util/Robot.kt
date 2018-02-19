package sample.util

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf
import sample.customMatches.hintWithText

/**
 * Created by caique on 2/20/18.
 */
abstract class Robot {
    fun checkHintWithText(viewId: Int, text: String) {
        Espresso.onView(withId(viewId))
                .check(matches(allOf(isDisplayed(), hintWithText(text))))
    }

    fun checkViewWithText(viewId: Int, text: String) {

        Espresso.onView(withId(viewId))
                .check(matches(allOf(isDisplayed(), withText(text))))
    }
}