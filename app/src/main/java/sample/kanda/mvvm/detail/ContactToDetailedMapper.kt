package sample.kanda.mvvm.detail

import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/15/2018.
 */
object ContactToDetailedMapper {
    val cnpjFormater: Formatter = CnpjFormatter()
    val phoneFormatter: Formatter = PhoneFormatter()

    operator fun invoke(contact: Contact): DetailedContact {
        return DetailedContact(
                name = contact.name,
                email = contact.email,
                phone = phoneFormatter.format(contact.telephone),
                companyName = contact.fantasyName,
                cnpj = cnpjFormater.format(contact.cnpj),
                isMei = contact.isMei,
                data = ""
        )
    }
}