package sample.kanda.mvvm

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import sample.kanda.data.InMemory
import sample.kanda.data.InMemoryLabels
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.RetrieveLabels
import sample.kanda.mvvm.detail.DetailViewModel
import sample.kanda.mvvm.home.HomeViewModel

/**
 * Created by jcosilva on 2/5/2018.
 */
class Injector {
    val kodein = Kodein {

        bind<RetrieveContacts>() with provider { InMemory() }

        bind<RetrieveLabels>() with provider { InMemoryLabels() }

        bind<HomeViewModel>() with provider {
            HomeViewModel(contacts = instance())
        }

        bind<DetailViewModel>() with provider {
            DetailViewModel(
                    contactDataSource = instance(),
                    fieldDataSource = instance()
            )
        }
    }
}