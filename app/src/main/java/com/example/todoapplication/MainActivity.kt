package com.example.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.todoapplication.adapter.TodoListAdapter
import com.example.todoapplication.appDatabase.AppDatabase
import com.example.todoapplication.dataClass.Todo
import com.example.todoapplication.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private lateinit var todoList: MutableList<Todo>
    private lateinit var adapter: TodoListAdapter
    private lateinit var listener: DbUpdaterListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        binding.addTodoButton.setOnClickListener {
            val todo = Todo(
                null,
                text = binding.inputTodoEditText.text.toString(),
                time = System.currentTimeMillis()
            )
            setIntoDB(todo)
        }
    }

    override fun onResume() {
        super.onResume()
        updateView()
    }

    private fun setIntoDB(todo: Todo) {
        Thread {
            db.todoDao().inputTodo(todo)
            updateView()
        }.start()

    }

    private fun deleteTodo(todo: Todo) {
        Thread {
            db.todoDao().deleteTodo(todo)
            updateView()
        }.start()

    }

    private fun updateView() {
        Thread {
            val list = db.todoDao().getAll()

            adapter.list = list
            runOnUiThread {
                adapter.notifyDataSetChanged()
            }
        }.start()

    }

    private fun init() {
        initDatabase()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        todoList = mutableListOf()
        adapter = TodoListAdapter(todoList) { todo ->
            deleteTodo(todo)
        }

        binding.todoListRecyclerView.adapter = adapter
        binding.todoListRecyclerView.layoutManager = LinearLayoutManager(this)

        listener = DbUpdaterListener(adapter)
    }

    private fun initDatabase() {
        db = Room.databaseBuilder(this, AppDatabase::class.java, "todoList").build()
    }

}