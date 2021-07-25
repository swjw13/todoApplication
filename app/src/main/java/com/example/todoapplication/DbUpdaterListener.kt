package com.example.todoapplication

import com.example.todoapplication.adapter.TodoListAdapter
import com.example.todoapplication.dataClass.Todo

class DbUpdaterListener(val adapter: TodoListAdapter): DatabaseListener {
    override fun updateView(todo: Todo) {
//        adapter.list.add(todo)
//        adapter.notifyDataSetChanged()
    }

    override fun deleteView(todo: Todo) {
//        adapter.list.remove(todo)
//        adapter.notifyDataSetChanged()
    }
}