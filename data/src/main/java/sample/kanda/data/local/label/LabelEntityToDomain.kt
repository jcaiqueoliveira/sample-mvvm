package sample.kanda.data.local.contact

import sample.kanda.domain.Label
import sample.kanda.domain.Mei

/**
 * Created by caique on 2/16/18.
 */
object LabelEntityToDomain {
    operator fun invoke(labelEntity: LabelEntity): Label {
        return labelEntity.run {
            Label(
                    labelName = name,
                    labelEmail = email,
                    labelTelephone = phone,
                    labelFantasyName = fantasy_Name,
                    labelCnpj = cnpj,
                    mei = Mei(
                            labelMei = title_mei,
                            labelPositiveOption = positive_option_mei,
                            labelNegativeOption = negative_option_mei)
            )
        }
    }
}