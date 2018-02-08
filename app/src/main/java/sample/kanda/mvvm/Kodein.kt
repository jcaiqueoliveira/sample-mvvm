package sample.kanda.mvvm

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import sample.kanda.data.LocalDataSource
import sample.kanda.data.RetrieveContactsDataSource
import sample.kanda.domain.LocalRepository
import sample.kanda.domain.RetrieveContacts
import sample.kanda.mvvm.home.HomeViewModel

/**
 * Created by jcosilva on 2/5/2018.
 */
class Injector {
    val kodein = Kodein {

        bind<LocalRepository>() with provider { LocalDataSource() }

        bind<RetrieveContacts>() with provider { RetrieveContactsDataSource() }

        bind<HomeViewModel>() with provider {
            HomeViewModel(contacts = instance())
        }

    }
}