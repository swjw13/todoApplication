package com.example.todoapplication.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapplication.dataClass.Todo

@Dao
interface TodoDao {
    @Insert
    fun inputTodo(todo: Todo)

    @Query("SELECT * FROM todo")
    fun getAll(): List<Todo>

    @Delete
    fun deleteTodo(todo: Todo)
}