package sample.kanda.mvvm

import android.content.Context
import com.github.salomonbrys.kodein.*
import sample.kanda.data.InMemory
import sample.kanda.data.InMemoryLabels
import sample.kanda.data.local.AppDataBase
import sample.kanda.data.local.contact.ContactDataSource
import sample.kanda.data.local.dataBaseBuilder
import sample.kanda.domain.RetrieveContacts
import sample.kanda.domain.RetrieveLabels
import sample.kanda.mvvm.detail.DetailViewModel
import sample.kanda.mvvm.home.HomeViewModel

/**
 * Created by jcosilva on 2/5/2018.
 */
class Injector(context: Context) {
    val kodein = Kodein {

        bind<RetrieveContacts>(IN_MEMORY) with provider { InMemory() }

        bind<RetrieveLabels>() with provider { InMemoryLabels() }

        bind<HomeViewModel>() with provider {
            HomeViewModel(contacts = instance(LOCAL))
        }

        bind<DetailViewModel>() with provider {
            DetailViewModel(
                    contactDataSource = instance(),
                    fieldDataSource = instance()
            )
        }

        bind<AppDataBase>() with singleton { dataBaseBuilder(context) }

        bind<RetrieveContacts>(LOCAL) with provider {
            ContactDataSource(
                    contactDao = instance<AppDataBase>().contactDao())
        }

    }

    companion object {
        val IN_MEMORY = "inMemory"
        val LOCAL = "local"
    }
}