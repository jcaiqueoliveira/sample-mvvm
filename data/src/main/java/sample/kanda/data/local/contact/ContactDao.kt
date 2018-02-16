package sample.kanda.data.local.contact

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by caique on 2/16/18.
 */
@Dao
interface ContactDao {

    @Query("select * from ContactTb")
    fun getAllContacts(): List<ContactEntity>

    @Query("select * from ContactTb where id = :contactId")
    fun findContactById(contactId: Int): ContactEntity

    @Insert(onConflict = REPLACE)
    fun insertContact(contact: ContactEntity)

    @Update(onConflict = REPLACE)
    fun updateContact(contact: ContactEntity)

    @Delete
    fun deleteContact(contact: ContactEntity)
}