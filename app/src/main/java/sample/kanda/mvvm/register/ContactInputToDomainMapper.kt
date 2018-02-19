package sample.kanda.mvvm.register

import sample.kanda.domain.Contact

/**
 * Created by caique on 2/19/18.
 */


object ContactInputToDomainMapper {
    operator fun invoke(userContactInput: UserContactInput): Contact {
        userContactInput.run {
            return Contact(
                    name = name,
                    email = email,
                    cnpj = cnpj,
                    isMei = isMei ?: false,
                    fantasyName = fantasyName,
                    telephone = telephone
            )
        }
    }
}