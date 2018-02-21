package sample.kanda.data

import sample.kanda.domain.*

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

    override fun getScreenLabels(): Either<List<Label>> {
        return tryOrError {
            listOf(label)
        }
    }
}