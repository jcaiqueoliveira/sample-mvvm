package sample.kanda.data.local.contact

import sample.kanda.domain.Either
import sample.kanda.domain.Label
import sample.kanda.domain.RetrieveLabels
import sample.kanda.domain.tryOrError

/**
 * Created by caique on 2/16/18.
 */
class LabelDataSource(val labelDao: LabelDao) : RetrieveLabels {
    override fun getScreenLabels(): Either<List<Label>> {
        return tryOrError {
            labelDao
                    .getAllLabels()
                    .map { LabelEntityToDomain(it) }
        }
    }
}

