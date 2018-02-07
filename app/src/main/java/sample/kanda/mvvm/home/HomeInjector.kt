package sample.kanda.mvvm.home

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import sample.kanda.data.InMemory
import sample.kanda.domain.LocalRepository

/**
 * Created by jcosilva on 2/6/2018.
 */

val homeModule = Kodein.Module {

    bind<HomeViewModel>() with provider {
        HomeViewModel(contactManagerUseCase = instance())
    }

    bind<LocalRepository>("InMemory") with provider { InMemory() }

}


