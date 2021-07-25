package com.example.todoapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.dataClass.Todo

interface DatabaseListener {
    fun updateView(todo: Todo)
    fun deleteView(todo: Todo)
}