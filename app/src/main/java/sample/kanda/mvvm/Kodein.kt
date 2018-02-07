package sample.kanda.mvvm

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import sample.kanda.data.LocalDataSource
import sample.kanda.domain.ContactManagerUseCase
import sample.kanda.domain.LocalRepository
import sample.kanda.mvvm.home.homeModule

/**
 * Created by jcosilva on 2/5/2018.
 */
class Injector {
    val kodein = Kodein {

        bind<ContactManagerUseCase>() with provider { ContactManagerUseCase(dataSource = instance("InMemory")) }

        bind<LocalRepository>(DB) with provider { LocalDataSource() }

        import(homeModule)
    }

    companion object {
        val DB = "DataBase"
    }
}