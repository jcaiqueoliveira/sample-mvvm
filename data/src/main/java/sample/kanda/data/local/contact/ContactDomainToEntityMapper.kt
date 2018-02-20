package sample.kanda.data.local.contact

import sample.kanda.domain.Contact

/**
 * Created by caique on 2/19/18.
 */
object ContactDomainToEntityMapper {
    operator fun invoke(contact: Contact): ContactEntity {
        return contact.run {

            ContactEntity(
                    name = name,
                    email = email,
                    phone = telephone,
                    fantasy_Name = fantasyName,
                    cnpj = cnpj,
                    mei = isMei
            )
        }
    }
}