package sample.customMatches

import android.support.design.widget.TextInputLayout
import android.view.View

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Created by caique on 2/19/18.
 */

fun hintWithText(expectedText: String): Matcher<View> {
    return object : TypeSafeMatcher<View>() {

        public override fun matchesSafely(view: View): Boolean {
            if (view !is TextInputLayout) {
                return false
            }

            val hint = view.hint ?: return false

            return expectedText == hint.toString()
        }

        override fun describeTo(description: Description) {}
    }
}

