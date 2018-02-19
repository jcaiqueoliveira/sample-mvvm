package sample.kanda.data.local.contact

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import sample.kanda.data.FieldsDatabase.CONTACT_ID
import sample.kanda.data.FieldsDatabase.TABLE_CONTACT

/**
 * Created by caique on 2/16/18.
 */
@Dao
interface ContactDao {

    @Query("select * from $TABLE_CONTACT")
    fun getAllContacts(): List<ContactEntity>

    @Query("select * from $TABLE_CONTACT where $CONTACT_ID = :contactId")
    fun findContactById(contactId: Int): ContactEntity

    @Insert(onConflict = REPLACE)
    fun insertContact(contact: ContactEntity)

    @Update(onConflict = REPLACE)
    fun updateContact(contact: ContactEntity)

    @Delete
    fun deleteContact(contact: ContactEntity)
}