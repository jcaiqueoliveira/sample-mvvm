package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

data class Label(val labelName: String,
                 val labelEmail: String,
                 val labelTelephone: String,
                 val labelFantasyName: String,
                 val labelCnpj: String,
                 val labelMei: String,
                 val action: Action? = null)

data class Action(val url: String)

data class Company(val name: String,
                   val email: String,
                   val telephone: String,
                   val fantasyName: String,
                   val cnpj: String,
                   val isMei: Boolean)