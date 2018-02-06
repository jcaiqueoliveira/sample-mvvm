package sample.kanda.data

import sample.kanda.domain.Company
import sample.kanda.domain.FieldsRepository
import sample.kanda.domain.Label
import sample.kanda.domain.LocalRepository

/**
 * Created by jcosilva on 2/5/2018.
 */

class LocalDataSource : LocalRepository, FieldsRepository {
    override fun create(label: Label) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLabelsScreen(): Label {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(company: Company) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompanies(): List<Company> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}