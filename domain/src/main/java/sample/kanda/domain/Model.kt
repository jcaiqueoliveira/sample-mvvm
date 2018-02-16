package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */

data class Label(val labelName: String,
                 val labelEmail: String,
                 val labelTelephone: String,
                 val labelFantasyName: String,
                 val labelCnpj: String,
                 val mei: Mei)

data class Mei(
        val labelMei: String,
        val labelPositiveOption: String,
        val labelNegativeOption: String)

data class Contact(val name: String,
                   val email: String,
                   val telephone: String,
                   val fantasyName: String,
                   val cnpj: String,
                   val isMei: Boolean)