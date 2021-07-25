package com.example.todoapplication.appDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication.Dao.TodoDao
import com.example.todoapplication.dataClass.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
}