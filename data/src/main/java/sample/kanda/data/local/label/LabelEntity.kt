package sample.kanda.data.local.contact

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by caique on 2/16/18.
 */

@Entity(tableName = "LabelTb")
data class LabelEntity(
        @ColumnInfo(name = "label_name") val name: String,
        @ColumnInfo(name = "label_email") val email: String,
        @ColumnInfo(name = "label_phone") val phone: String,
        @ColumnInfo(name = "label_company_name") val fantasy_Name: String,
        @ColumnInfo(name = "label_cnpj") val cnpj: String,
        @ColumnInfo(name = "label_title_mei") val title_mei: String,
        @ColumnInfo(name = "label_positive_option") val positive_option_mei: String,
        @ColumnInfo(name = "label_negative_option") val negative_option_mei: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}