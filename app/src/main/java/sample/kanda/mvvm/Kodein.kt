package sample.kanda.mvvm

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import sample.kanda.data.InMemory
import sample.kanda.domain.RetrieveContacts
import sample.kanda.mvvm.home.HomeViewModel

/**
 * Created by jcosilva on 2/5/2018.
 */
class Injector {
    val kodein = Kodein {

        bind<RetrieveContacts>() with provider { InMemory() }

        bind<HomeViewModel>() with provider {
            HomeViewModel(contacts = instance())
        }
    }
}