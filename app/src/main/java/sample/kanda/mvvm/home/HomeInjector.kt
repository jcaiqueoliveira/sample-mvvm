package sample.kanda.mvvm.home

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider

/**
 * Created by jcosilva on 2/6/2018.
 */

val homeModule = Kodein.Module {

    bind<HomeViewModel>() with provider {
        HomeViewModel(contactManagerUseCase = instance())
    }

}