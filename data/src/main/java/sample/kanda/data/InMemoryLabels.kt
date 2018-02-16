package sample.kanda.data

import sample.kanda.domain.Label
import sample.kanda.domain.Mei
import sample.kanda.domain.RetrieveLabels

/**
 * Created by jcosilva on 2/15/2018.
 */
class InMemoryLabels : RetrieveLabels {
    val label = Label(
            labelName = "Nome",
            labelEmail = "Email contato",
            labelTelephone = "Telefone",
            labelFantasyName = "Nome Empresa",
            labelCnpj = "Cnpj",
            mei = Mei("É do tipo MEI ?", "Sim", "Não"))

    override fun getScreenLabels(): List<Label> {
        return listOf(label)
    }
}