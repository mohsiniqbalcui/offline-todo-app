package com.familyaura.todo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.familyaura.todo.data.BuyData

@Dao
interface BuyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrCreate(buyData: List<BuyData>)

    @Query("SELECT * FROM ItemToSell ORDER BY id ")
    fun getData(): LiveData<List<BuyData>>

}