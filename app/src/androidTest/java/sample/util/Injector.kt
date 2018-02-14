package sample.util

import com.github.salomonbrys.kodein.*
import com.nhaarman.mockito_kotlin.mock
import sample.kanda.data.InMemoryLabels
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.RetrieveLabels
import sample.kanda.mvvm.detail.DetailViewModel
import sample.kanda.mvvm.home.HomeViewModel

/**
 * Created by jcosilva on 2/14/2018.
 */
class InjectorTest {
    val kodein = Kodein {

        bind<RetrieveContacts>() with singleton { mock<RetrieveContacts>() }

        bind<RetrieveLabels>() with singleton { mock<InMemoryLabels>() }

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