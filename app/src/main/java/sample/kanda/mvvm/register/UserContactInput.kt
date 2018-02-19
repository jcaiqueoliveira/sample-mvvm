package sample.kanda.mvvm.register

/**
 * Created by caique on 2/19/18.
 */


data class UserContactInput(
        var name: String = "",
        var email: String = "",
        var telephone: String = "",
        var fantasyName: String = "",
        var cnpj: String = "",
        var isMei: Boolean? = null)
