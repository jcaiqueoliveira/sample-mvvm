package sample.kanda.data.local

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import sample.kanda.data.local.contact.ContactDao
import sample.kanda.data.local.contact.ContactEntity
import sample.kanda.data.local.contact.LabelDao
import sample.kanda.data.local.contact.LabelEntity
import java.util.concurrent.Executors

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
        //https://gist.github.com/florina-muntenescu/697e543652b03d3d2a06703f5d6b44b5
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: dataBaseBuilder(context).also { INSTANCE = it }
            }
        }

        fun dataBaseBuilder(context: Context): AppDataBase {
            return Room
                    .databaseBuilder(context, AppDataBase::class.java, "sample-db")
                    .allowMainThreadQueries()
                    .addCallback(populateDataBase(context))
                    .build()

        }

        private fun populateDataBase(context: Context) = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Executors
                        .newSingleThreadExecutor()
                        .execute({ getInstance(context).labelDao().insertLabel(PREPOPULATE_DATA) })
            }
        }

        private val PREPOPULATE_DATA = LabelEntity(
                name = "Nome",
                email = "Email contato",
                phone = "Telefone",
                fantasy_Name = "Nome Empresa",
                cnpj = "Cnpj",
                title_mei = "É do tipo MEI ?",
                positive_option_mei = "Sim",
                negative_option_mei = "Não")

    }

}
