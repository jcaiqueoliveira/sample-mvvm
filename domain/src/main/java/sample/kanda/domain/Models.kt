package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

data class Field(val label: String, val action: String)

data class Navigator(val url: String)

data class Company(val name: String,
                   val email: String,
                   val telephone: String,
                   val fantasyName: String,
                   val cnpj: String,
                   val isMei: Boolean
)