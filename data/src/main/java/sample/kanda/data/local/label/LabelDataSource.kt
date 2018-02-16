package sample.kanda.data.local.contact

import sample.kanda.domain.Label
import sample.kanda.domain.RetrieveLabels

/**
 * Created by caique on 2/16/18.
 */
class LabelDataSource(val labelDao: LabelDao) : RetrieveLabels {
    override fun getScreenLabels(): List<Label> {
        return labelDao
                .getAllLabels()
                .map { LabelEntityToDomain(it) }

    }
}

