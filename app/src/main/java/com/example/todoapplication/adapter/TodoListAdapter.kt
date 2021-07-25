package com.example.todoapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.DatabaseListener
import com.example.todoapplication.DbUpdaterListener
import com.example.todoapplication.R
import com.example.todoapplication.dataClass.Todo
import com.example.todoapplication.databinding.TodoItemviewBinding

class TodoListAdapter(var list: List<Todo>, val function: (todo: Todo) -> Unit): RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>(){

    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(todo: Todo){
            itemView.findViewById<TextView>(R.id.todoEach).text = todo.text
            itemView.findViewById<ImageButton>(R.id.minusButton).setOnClickListener {
                // TODO: 데이터를 db에서 삭제한 후 뷰를 업데이트하기
                function(todo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_itemview, parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        list[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int = list.size
}