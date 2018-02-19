package sample.kanda.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.design.widget.TextInputLayout
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.Toast

/**
 * Created by jcosilva on 2/7/2018.
 */
//https://github.com/ubiratansoares/kryptokarteira-mobile/blob/master/core-architecture/src/main/java/br/ufs/architecture/core/presentation/util/ViewModels.kt
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


fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun TextInputLayout.clearErrorMsg() {
    error = null
}