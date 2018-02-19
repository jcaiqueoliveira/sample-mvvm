package sample.kanda.data.local.contact

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import sample.kanda.data.FieldsDatabase.LABEL_CNPJ
import sample.kanda.data.FieldsDatabase.LABEL_COMPANY_NAME
import sample.kanda.data.FieldsDatabase.LABEL_EMAIL
import sample.kanda.data.FieldsDatabase.LABEL_ID
import sample.kanda.data.FieldsDatabase.LABEL_NAME
import sample.kanda.data.FieldsDatabase.LABEL_NEGATIVE_OPTION
import sample.kanda.data.FieldsDatabase.LABEL_PHONE
import sample.kanda.data.FieldsDatabase.LABEL_POSITIVE_OPTION
import sample.kanda.data.FieldsDatabase.LABEL_TITLE_MEI
import sample.kanda.data.FieldsDatabase.TABLE_LABEL

/**
 * Created by caique on 2/16/18.
 */

@Entity(tableName = TABLE_LABEL)
data class LabelEntity(
        @ColumnInfo(name = LABEL_NAME) val name: String,
        @ColumnInfo(name = LABEL_EMAIL) val email: String,
        @ColumnInfo(name = LABEL_PHONE) val phone: String,
        @ColumnInfo(name = LABEL_COMPANY_NAME) val fantasy_Name: String,
        @ColumnInfo(name = LABEL_CNPJ) val cnpj: String,
        @ColumnInfo(name = LABEL_TITLE_MEI) val title_mei: String,
        @ColumnInfo(name = LABEL_POSITIVE_OPTION) val positive_option_mei: String,
        @ColumnInfo(name = LABEL_NEGATIVE_OPTION) val negative_option_mei: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = LABEL_ID)
    var id: Int = 0
}