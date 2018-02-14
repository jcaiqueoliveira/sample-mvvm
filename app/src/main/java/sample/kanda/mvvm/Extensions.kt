package sample.kanda.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import android.view.View

/**
 * Created by jcosilva on 2/7/2018.
 */

@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(
        mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE,
        crossinline provider: () -> VM) = lazy(mode) {

    val factory = object : ViewModelProvider.Factory {
        override fun <Model : ViewModel> create(klass: Class<Model>) = provider() as Model
    }

    ViewModelProviders.of(this, factory).get(VM::class.java)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}