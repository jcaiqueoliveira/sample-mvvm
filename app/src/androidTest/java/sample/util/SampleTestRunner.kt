package sample.util

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import sample.kanda.TestApplication

/**
 * Created by jcosilva on 2/14/2018.
 */
class SampleTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}