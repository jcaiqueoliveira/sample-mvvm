package sample.kanda.mvvm

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import sample.kanda.data.*
import sample.kanda.domain.*

/**
 * Created by jcosilva on 2/5/2018.
 */
class Injector {
    val kodein = Kodein {

        bind<CompanyUseCase>() with provider { CompanyUseCase(dataSource = instance()) }

        bind<LocalRepository>() with provider { LocalDataSource() }
    }
}