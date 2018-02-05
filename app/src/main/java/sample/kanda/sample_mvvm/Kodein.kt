package sample.kanda.sample_mvvm

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import sample.kanda.data.LocalDataSource
import sample.kanda.domain.CompanyUseCase

/**
 * Created by jcosilva on 2/5/2018.
 */
class Injector {
    val kodein = Kodein {

        bind<CompanyUseCase>() with provider { CompanyUseCase(dataSource = instance()) }

        bind<LocalDataSource>() with provider { LocalDataSource() }

    }
}