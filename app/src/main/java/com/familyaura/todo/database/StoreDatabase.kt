package com.familyaura.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.familyaura.todo.data.BuyData

@Database(
    entities = [
        BuyData::class
    ],
    version = 1,
    exportSchema = false
)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun sellDao(): BuyDao

    companion object {
        @Volatile
        private var INSTANCE: StoreDatabase? = null

//        val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE BuyData ADD COLUMN photo TEXT NULL DEFAULT NULL")
//            }
//        }

        fun getDatabase(context: Context): StoreDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StoreDatabase::class.java,
                    "todo"
                )
//                    .addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}