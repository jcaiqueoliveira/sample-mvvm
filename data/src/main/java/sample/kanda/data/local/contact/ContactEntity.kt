package sample.kanda.data.local.contact

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import sample.kanda.data.FieldsDatabase.CONTACT_CNPJ
import sample.kanda.data.FieldsDatabase.CONTACT_COMPANY_NAME
import sample.kanda.data.FieldsDatabase.CONTACT_EMAIL
import sample.kanda.data.FieldsDatabase.CONTACT_ID
import sample.kanda.data.FieldsDatabase.CONTACT_MEI
import sample.kanda.data.FieldsDatabase.CONTACT_NAME
import sample.kanda.data.FieldsDatabase.CONTACT_PHONE
import sample.kanda.data.FieldsDatabase.TABLE_CONTACT

/**
 * Created by caique on 2/16/18.
 */

@Entity(tableName = TABLE_CONTACT)
data class ContactEntity(
        @ColumnInfo(name = CONTACT_NAME) val name: String,
        @ColumnInfo(name = CONTACT_EMAIL) val email: String,
        @ColumnInfo(name = CONTACT_PHONE) val phone: String,
        @ColumnInfo(name = CONTACT_COMPANY_NAME) val fantasy_Name: String,
        @ColumnInfo(name = CONTACT_CNPJ) val cnpj: String,
        @ColumnInfo(name = CONTACT_MEI) val mei: Boolean = false) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CONTACT_ID)
    var id: Int = 0
}