package sample.kanda.domain

/**
 * Created by jcosilva on 2/5/2018.
 */
class CompanyUseCase(val dataSource: LocalRepository) {

    fun save(company: Company) {
        dataSource.create(company)
    }
}