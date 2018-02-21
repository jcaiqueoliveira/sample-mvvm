package sample.kanda.mvvm.detail

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import sample.kanda.domain.Label
import sample.kanda.mvvm.R
import sample.util.Robot

/**
 * Created by caique on 2/20/18.
 */
class DetailRobot : Robot() {
    lateinit var contact: DetailedContact
    lateinit var label: Label

    fun withPair(pair: Pair<DetailedContact, Label>): DetailRobot {
        this.contact = pair.first
        this.label = pair.second
        return this
    }

    fun checkIfLabelsAreShownCorrectly(): DetailRobot {
        label.apply {
            checkHintWithText(R.id.detailCnpj, labelCnpj)
            checkHintWithText(R.id.detailEmail, labelEmail)
            checkHintWithText(R.id.detailName, labelName)
            checkHintWithText(R.id.detailFantasyName, labelFantasyName)
            checkHintWithText(R.id.detailPhone, labelTelephone)
            checkViewWithText(R.id.detailTextMei, mei.labelMei)
            checkViewWithText(R.id.detailNegativeOption, mei.labelNegativeOption)
            checkViewWithText(R.id.detailPositiveOption, mei.labelPositiveOption)
        }

        return this
    }

    fun checkIfContactIsShownCorrectly(): DetailRobot {
        contact.apply {
            checkIfViewWithTextIsDisplayed(name)
            checkIfViewWithTextIsDisplayed(email)
            checkIfViewWithTextIsDisplayed(cnpj)
            checkIfViewWithTextIsDisplayed(companyName)
            checkIfViewWithTextIsDisplayed(phone)
        }
        return this
    }

    fun excludeButton(){
        onView(withId(R.id.detailExcludeAction)).perform(click())
    }

}