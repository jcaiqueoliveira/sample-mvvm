package sample.util

import android.app.Activity
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.Intents
import android.support.test.rule.ActivityTestRule
import com.github.salomonbrys.kodein.Kodein
import org.junit.Rule
import sample.kanda.mvvm.Injector
import sample.kanda.testApplication

/**
 * Created by jcosilva on 2/15/2018.
 */
abstract class ActivityRule<T : Activity>(clazz: Class<T>) {

    @get:Rule
    val rule: ActivityTestRule<T> = ActivityTestRule(clazz, true, false)

    val injector = InstrumentationRegistry
            .getInstrumentation()
            .targetContext
            .testApplication()
            .kodein

    fun beforeTests() {
        Intents.init()

        injector.addExtend(
                kodein = Injector(InstrumentationRegistry
                        .getInstrumentation()
                        .context)
                        .kodein,
                allowOverride = true)

    }

    fun startActivity(intent: Intent? = null) {
        val i = intent ?: Intent()
        rule.launchActivity(i)
    }

    fun addModule(module: Kodein.Module) {
        injector.addImport(module, true)
    }

    fun afterTests() {
        injector.clear()
        Intents.release()
    }

}