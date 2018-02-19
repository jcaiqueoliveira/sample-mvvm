package sample.kanda.mvvm.register

import sample.kanda.domain.Label
import sample.kanda.mvvm.R
import sample.util.Robot

/**
 * Created by caique on 2/19/18.
 */
class RobotRegister : Robot() {

    private lateinit var label: Label

    fun withLabel(label: Label): RobotRegister {
        this.label = label
        return this
    }

    fun checkIfViewsWithHintAreShownCorrectly(): RobotRegister {
        checkHintWithText(R.id.registerName, label.labelName)

        checkHintWithText(R.id.registerEmail, label.labelEmail)

        checkHintWithText(R.id.registerCnpj, label.labelCnpj)

        checkHintWithText(R.id.registerCompany, label.labelFantasyName)

        checkHintWithText(R.id.registerPhone, label.labelTelephone)

        return this
    }

    fun checkViewsTextAreShownCorrectly(): RobotRegister {

        checkViewWithText(R.id.registerTextMei, label.mei.labelMei)

        checkViewWithText(R.id.registerPositiveOption, label.mei.labelPositiveOption)

        checkViewWithText(R.id.registerNegativeOption, label.mei.labelNegativeOption)

        return this
    }

}