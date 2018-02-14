package sample.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import sample.kanda.asApp

/**
 * Created by jcosilva on 2/15/2018.
 */
abstract class ActivityRule<T : Activity>(clazz: Class<T>) {

    @get:Rule
    val rule: ActivityTestRule<T> = ActivityTestRule(clazz, true, false)

    val injector = InstrumentationRegistry.getInstrumentation().targetContext.asApp().kodein

    fun startActivity(b: Bundle? = null) {
        Intent().apply {
            b?.apply { putExtras(b) }
            rule.launchActivity(this)
        }
    }


}