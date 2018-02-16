package sample.kanda.data.local.contact

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by caique on 2/16/18.
 */
@Dao
interface LabelDao {

    @Query("select * from LabelTb")
    fun getAllLabels(): List<LabelEntity>

    @Query("select * from LabelTb where id = :labelId")
    fun findLabelById(labelId: Int): LabelEntity

    @Insert(onConflict = REPLACE)
    fun insertLabel(label: LabelEntity)

    @Update(onConflict = REPLACE)
    fun updateLabel(label: LabelEntity)

    @Delete
    fun deleteLabel(label: LabelEntity)
}