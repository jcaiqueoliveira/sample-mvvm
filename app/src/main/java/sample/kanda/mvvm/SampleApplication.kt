package sample.kanda.mvvm

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware

/**
 * Created by jcosilva on 2/5/2018.
 */
class SampleApplication : Application(), KodeinAware {
    override val kodein: Kodein = Injector(this).kodein
}