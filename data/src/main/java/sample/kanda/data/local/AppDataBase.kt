package sample.kanda.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import sample.kanda.data.local.contact.ContactDao
import sample.kanda.data.local.contact.ContactEntity

/**
 * Created by caique on 2/16/18.
 */
@Database(entities = [(ContactEntity::class)], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}


fun dataBaseBuilder(context: Context): AppDataBase {
    return Room
            .databaseBuilder(context, AppDataBase::class.java, "sample-db")
            .allowMainThreadQueries()
            .build()

}