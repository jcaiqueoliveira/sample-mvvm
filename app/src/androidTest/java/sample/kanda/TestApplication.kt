package sample.kanda

import android.app.Application
import android.content.Context
import android.util.Log
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import sample.util.InjectorTest

/**
 * Created by jcosilva on 2/14/2018.
 */
class TestApplication : Application(), KodeinAware {
    override val kodein: Kodein = InjectorTest().kodein
    override fun onCreate() {
        super.onCreate()
        Log.e("opa", "opa")
    }
}

fun Context.asApp() = this.applicationContext as TestApplication