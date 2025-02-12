package com.example.recipeappproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipeappproject.DataClasses.RegisterEntity
import com.example.recipeappproject.dao.RegisterDatabaseDao

@Database(entities = [RegisterEntity::class], version = 1, exportSchema = false)
abstract class RegisterDatabase : RoomDatabase() {

    abstract val registerDatabaseDao: RegisterDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: RegisterDatabase? = null


        fun getInstance(context: Context): RegisterDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RegisterDatabase::class.java,
                        "user_details_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}