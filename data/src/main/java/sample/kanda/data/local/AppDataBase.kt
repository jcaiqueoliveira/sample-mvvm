package sample.kanda.data.local

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
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
import sample.kanda.data.local.contact.ContactDao
import sample.kanda.data.local.contact.ContactEntity
import sample.kanda.data.local.contact.LabelDao
import sample.kanda.data.local.contact.LabelEntity

/**
 * Created by caique on 2/16/18.
 */
@Database(
        entities = [(ContactEntity::class), (LabelEntity::class)],
        version = 1,
        exportSchema = false)

abstract class AppDataBase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun labelDao(): LabelDao


    companion object {

        fun dataBaseBuilder(context: Context): AppDataBase {
            return Room
                    .databaseBuilder(context, AppDataBase::class.java, "sample-db")
                    .allowMainThreadQueries()
                    .addCallback(callBackToPopulateDataBase(context))
                    .build()

        }

        private fun callBackToPopulateDataBase(context: Context) = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.insert(TABLE_LABEL, SQLiteDatabase.CONFLICT_REPLACE, populateDatabase())
            }
        }

        private fun populateDatabase(): ContentValues {
            return ContentValues().apply {
                put(LABEL_ID, 0)
                put(LABEL_NAME, "Nome")
                put(LABEL_EMAIL, "Email contato")
                put(LABEL_PHONE, "Telefone")
                put(LABEL_COMPANY_NAME, "Nome Fantasia")
                put(LABEL_CNPJ, "Cnpj")
                put(LABEL_TITLE_MEI, "É tipo MEI?")
                put(LABEL_POSITIVE_OPTION, "Sim")
                put(LABEL_NEGATIVE_OPTION, "Não")
            }
        }
    }

}
