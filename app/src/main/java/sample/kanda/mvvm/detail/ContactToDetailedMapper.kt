package sample.kanda.mvvm.detail

import sample.kanda.domain.Contact

/**
 * Created by jcosilva on 2/15/2018.
 */
object ContactToDetailedMapper {
    val cnpjFormater: Formatter = CnpjFormatter()
    val phoneFormatter: Formatter = PhoneFormatter()

    operator fun invoke(contact: Contact): DetailedContact {
        return contact.run {
            DetailedContact(
                    id = id,
                    name = name,
                    email = email,
                    phone = phoneFormatter.format(telephone),
                    companyName = fantasyName,
                    cnpj = cnpjFormater.format(cnpj),
                    isMei = isMei,
                    data = "")
        }
    }
}