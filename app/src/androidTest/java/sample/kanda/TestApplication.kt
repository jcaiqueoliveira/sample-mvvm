package sample.kanda

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.conf.ConfigurableKodein

/**
 * Created by jcosilva on 2/14/2018.
 */
class TestApplication : Application(), KodeinAware {
    override val kodein = ConfigurableKodein(mutable = true)
}

fun Context.testApplication() = this.applicationContext as TestApplication