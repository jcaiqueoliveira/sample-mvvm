package sample.kanda.data.local.contact

import sample.kanda.domain.Contact

/**
 * Created by caique on 2/16/18.
 */
object ContactEntityToDomain {
    operator fun invoke(contactEntity: ContactEntity): Contact {
        return contactEntity.run {
            Contact(
                    name = name,
                    email = email,
                    telephone = phone,
                    fantasyName = fantasy_Name,
                    cnpj = cnpj,
                    isMei = mei
            )
        }
    }
}