package sample.kanda.data.local.contact

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import sample.kanda.data.FieldsDatabase.LABEL_ID
import sample.kanda.data.FieldsDatabase.TABLE_LABEL

/**
 * Created by caique on 2/16/18.
 */
@Dao
interface LabelDao {

    @Query("select * from $TABLE_LABEL")
    fun getAllLabels(): List<LabelEntity>

    @Query("select * from $TABLE_LABEL where $LABEL_ID = :labelId")
    fun findLabelById(labelId: Int): LabelEntity

    @Insert(onConflict = REPLACE)
    fun insertLabel(label: LabelEntity)

    @Update(onConflict = REPLACE)
    fun updateLabel(label: LabelEntity)

    @Delete
    fun deleteLabel(label: LabelEntity)
}