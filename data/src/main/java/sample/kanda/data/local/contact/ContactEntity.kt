package sample.kanda.data.local.contact

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by caique on 2/16/18.
 */

@Entity(tableName = "ContactTb")
data class ContactEntity(
        @ColumnInfo(name = "contact_name") val name: String,
        @ColumnInfo(name = "contact_email") val email: String,
        @ColumnInfo(name = "contact_phone") val phone: String,
        @ColumnInfo(name = "contact_company_name") val fantasy_Name: String,
        @ColumnInfo(name = "contact_cnpj") val cnpj: String,
        @ColumnInfo(name = "contact_mei") val mei: Boolean = false) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}