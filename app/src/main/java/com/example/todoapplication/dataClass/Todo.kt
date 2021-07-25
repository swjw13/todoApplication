package com.example.todoapplication.dataClass

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey val uid: Int?,
    @ColumnInfo(name="Todo") val text: String?,
    @ColumnInfo(name="Time") val time: Long?,
    @ColumnInfo(name="IsDone") val isDone: Boolean? = false
)